package org.example.core;

class Message {
  public String role;
  public String message;

  public Message(String role, String message) {
    this.role = role;
    this.message = message;
  }
}

class LLMResponse {

}

/**
 * LLM_Interface
 */
public class LLM_Interface {
  protected String url;
  protected String port;
  protected String model;

  protected Boolean stream;
  protected Message[] messages;
  protected String systemPrompt;
  protected String fullURL;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public LLM_Interface(String url, String port, String model, boolean stream) {
    this.url = url;
    this.port = port;
    this.model = model;
    this.stream = stream;
  }

  public void generateResponse(String message) {
  }

}
