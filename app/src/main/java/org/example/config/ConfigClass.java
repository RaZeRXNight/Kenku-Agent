package org.example.config;

public class ConfigClass {
  private String name = "Jenny";
  private String model = "gemma4";
  private String version = "0.0.1";
  private String db_conn = "postresql://postgres";

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

}
