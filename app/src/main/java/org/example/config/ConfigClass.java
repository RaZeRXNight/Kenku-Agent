package org.example.config;

public class ConfigClass {
  private String name = "Jenny";
  private String model = "gemma4";
  private String version = "0.0.1";
  private String db_conn = "postresql://postgres";

  private String providerURL = "http://localhost";
  private String providerPort = "8080";
  private String providerModel = "gemma4";
  private Boolean providerStreaming = true;

  public ConfigClass() {
  };

  public ConfigClass(String name, String model) {
    this.name = name;
    this.model = model;
  }

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public String getVersion() {
    return version;
  }

  public String getDb_conn() {
    return db_conn;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setDb_conn(String db_conn) {
    this.db_conn = db_conn;
  }

  public String getProviderURL() {
    return providerURL;
  }

  public void setProviderURL(String providerURL) {
    this.providerURL = providerURL;
  }

  public String getProviderPort() {
    return providerPort;
  }

  public void setProviderPort(String providerPort) {
    this.providerPort = providerPort;
  }

  public String getProviderModel() {
    return providerModel;
  }

  public void setProviderModel(String providerModel) {
    this.providerModel = providerModel;
  }

  public Boolean getProviderStreaming() {
    return providerStreaming;
  }

  public void setProviderStreaming(Boolean providerStreaming) {
    this.providerStreaming = providerStreaming;
  }

}
