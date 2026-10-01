package org.example.core;

import java.util.ArrayList;

class Message {
  public String role;
  public String content;

  public Message(String role, String content) {
    this.role = role;
    this.content = content;
  }

  protected String stringFieldMapper(String firstArg, String SecondArg) {
    return String.format("\"%s\": \"%s\"", firstArg, SecondArg);
  }

  @Override
  public String toString() {
    String role = stringFieldMapper("role", this.role);
    String content = stringFieldMapper("content", this.content);
    String currentMessage = String.format("{%s}", String.join(",", role, content));
    return currentMessage;
  }
}

class LLMResponse {

}

/**
 * LLM_Interface
 */
public abstract class LLM_Interface {
  protected String url;
  protected String port;
  protected String path;
  protected String model;

  protected Boolean stream;
  protected ArrayList<Message> messages;
  protected String systemPrompt;
  protected String fullURL;

  protected String messagesToString() {
    ArrayList<String> messageCollection = new ArrayList<String>();
    for (Message message : messages) {
      messageCollection.add(message.toString());
    }
    return String.format("[%s]", String.join(",", messageCollection));
  }

  protected void appendMessage(String Role, String Content) {
    if (Role.strip().length() == 0) {
    }
    Message newMessage = new Message(Role.toLowerCase(), Content);
    messages.add(newMessage);
  }

  /**
   * Constructor
   * 
   * @param url
   * @param port
   * @param model
   * @param stream
   */
  public LLM_Interface(String url, String port, String model, boolean stream) {
    this.messages = new ArrayList<Message>();
    this.url = url;
    this.port = port;
    this.model = model;
    this.stream = stream;
  }

  public void generateResponse(String message) {
  }

}
