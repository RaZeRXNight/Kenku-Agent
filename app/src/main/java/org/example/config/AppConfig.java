package org.example.config;

import java.io.FileNotFoundException;
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
  public ConfigClass getConfig() throws FileNotFoundException {
    try {
      ConfigClass config = readConfig();
      return config;
    } catch (Exception e) {
      throw new FileNotFoundException("Unable to Load Configuration Settings.");
    }
  }

}
