package org.example.core;

import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Ollama_Interface
 */
public class Llama_CPP_Interface extends LLM_Interface {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private record ChatRequest(String model, List<Message> messages, Boolean stream) {
  }

  private String path = "/v1/chat/completions";

  public Llama_CPP_Interface(String url, String port, String model, boolean stream) {
    super(url, port, model, stream);
    String portNum = (port != null) ? ":" + port : "";
    fullURL = url + portNum + path;

  }

  public Llama_CPP_Interface(String url, String model, boolean stream) {
    super(url, "", model, stream);
    fullURL = url + path;

  }

  /**
   * (non-Javadoc)
   * 
   * @see org.example.core.LLM_Interface#generateResponse(java.lang.String)
   */
  public void generateResponse(String message) {
    appendMessage("User", message);

    try {
      String body = createRequestBody();
      System.out.println(body);

      // Build the Client
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest req = HttpRequest.newBuilder().uri(URI.create(fullURL))
          .headers("Content-Type", "application/json")
          .POST(BodyPublishers.ofString(body))
          .build();

      // Currently Sequential and Blocking
      HttpResponse<String> response = client.send(req, BodyHandlers.ofString());

      for (String line : response.body().split("\\R")) {
        if (!line.startsWith("data:")) {
          continue;
        }

        String json = line.substring("data:".length()).strip();

        if (json.equals("[DONE]")) {
          System.out.println();
          break;
        }
        if (json.isEmpty()) {
          continue;
        }

        LLMResponseMessage chunk = OBJECT_MAPPER.readValue(json, LLMResponseMessage.class);

        if (chunk.choices() != null) {
          for (LLMResponseMessage.Choice choice : chunk.choices()) {
            if (choice.delta() != null && choice.delta().content() != null) {
              System.out.print(choice.delta().content());
            }
          }
        }
      }

    } catch (JsonProcessingException e) {
      System.out.println("Unable to serialize request: " + e.getMessage());
    } catch (ConnectException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Unable to Connect");
      System.out.println(e);
    }
  }

  String createRequestBody() throws JsonProcessingException {
    return OBJECT_MAPPER.writeValueAsString(new ChatRequest(model, messages, stream));
  }

}
