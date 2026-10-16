package org.example.config;

import java.io.IOException;

/**
 * AppConfig
 *
 * Utilizes Path Class from java.nio.file
 * Uses FileSystem to resolve file locations.
 */
public class AppConfig extends BaseAppConfig {

  /**
   * Attempts to set a Configuration Value, based on the passed Record Value.
   * 
   * @return Returns a zero if successful, or non-zero if unsuccessful.
   */
  public int setConfigValue(String field, String value) {
    try {
      if (field.isBlank() || value.isBlank()) {
        return 1;
      }

      return 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @return returns the config value
   */
  public String getConfigValue(String field) {
    try {
      ConfigClass config = readConfig();
      System.out.println(config.name);
    } catch (Exception e) {
      return "ERROR";
    }
    return "";
  }

  /**
   * @return Returns a zero if successful, or non-zero if unsuccessful.
   */
  public int resetConfig() throws IOException {
    try {
      ConfigClass defaultConfig = new ConfigClass();
      writeConfig(defaultConfig);
    } catch (Exception e) {
      System.out.println(e);
    }

    return 0;
  }
}

class ConfigClass {
  public String name = "Jenny";
  public String model = "gemma4";
  public String version = "0.0.1";
  public String db_conn = "postresql://postgres";

  public ConfigClass() {
  };

  public ConfigClass(String name, String model) {
    this.name = name;
    this.model = model;
  }

}
