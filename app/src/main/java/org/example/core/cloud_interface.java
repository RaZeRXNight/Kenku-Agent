package org.example.core;

/**
 * cloud_interface
 */
public class cloud_interface extends LLM_Interface {
  private String apiKey;

  /**
   * @param url
   * @param port
   * @param model
   * @param apiKey
   * @param stream
   */
  public cloud_interface(String url, String port, String model, String apiKey, boolean stream) {
    super(url, port, model, stream);
    this.apiKey = apiKey;
  }

}
