package org.example.core;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Ollama_Interface
 */
public class Ollama_Interface extends LLM_Interface {

  public Ollama_Interface(String url, String port, String model, boolean stream) {
    super(url, port, model, stream);
    String portNum = (port != null) ? ":" + port : "";
    fullURL = url + portNum;

  }

  /**
   * (non-Javadoc)
   * 
   * @see org.example.core.LLM_Interface#generateResponse(java.lang.String)
   */
  public void generateResponse(String message) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder().uri(URI.create(fullURL))
        .headers("Content-Type", "application/json")
        .build();
    try {
      client.sendAsync(req, BodyHandlers.ofString())
          .thenApply(HttpResponse::body)
          .thenAccept(System.out::println)
          .join();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
