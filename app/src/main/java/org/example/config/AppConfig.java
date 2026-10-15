package org.example.config;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;

class DefaultConfig {
  HashMap<String, String> ConfigProperties = new HashMap<String, String>();

  DefaultConfig() {
    ConfigProperties.put("name", "val");
  }
}

/**
 * AppConfig
 *
 * Utilizes Path Class from java.nio.file
 * Uses FileSystem to resolve file locations.
 */
public class AppConfig {

  // Operating System Information
  private String osName = System.getProperty("os.name");
  private String osArch = System.getProperty("os.arch");
  private String osVersion = System.getProperty("os.version");

  // File Paths
  private FileSystem fs = FileSystems.getDefault();
  private String configName = "KenkuAgent";

  private Path userHome = fs.getPath(System.getProperty("user.home"));
  private Path TempDir = fs.getPath(System.getProperty("java.io.tmpdir"));
  private Path ConfigPath;
  private Path cwd = fs.getPath(System.getProperty("user.dir"));
  private HashMap<String, String> configMap = new HashMap<String, String>();

  /**
   * Sets the ConfigPath based on the operating system the user is using.
   * 
   * Utilizes Path Class from java.nio.file
   * 
   * @return
   */
  protected int getConfigPath() {
    switch (osName) {
      case "Linux":
        ConfigPath = fs.getPath(userHome.toString(), ".config", configName);
        System.out.println(ConfigPath);
        return 0;
      case "Windows":
        return 1;
      case "Mac":
        return 1;
      default:
        return 1;
    }
  }

  /**
   * Constructor
   */
  public AppConfig() {
    // Gracefully Exit program if user is on an Unsupported Operating System.
    if (getConfigPath() != 0) {
      System.out.println("ERROR: Operating System Unsupported");
      System.exit(1);
    }
  }

  /**
   * Attempts to set a Configuration Value, based on the passed Record Value.
   * 
   * @return Returns a zero if successful, or non-zero if unsuccessful.
   */
  public int setConfigValue(String field, String value) {
    if (field.isBlank() || value.isBlank()) {
      return 1;
    }

    return 0;
  }

  /**
   * @return returns the config value
   */
  public String getConfigValue(String field) {
    return "";
  }

  /**
   * @return Returns a zero if successful, or non-zero if unsuccessful.
   */
  public int resetConfig() {
    return 1;
  }

  public void outputProgramEnv() {
    System.out.println(String.format("osName: %s", osName));
    System.out.println(String.format("osArch: %s ", osArch));
    System.out.println(String.format("osVersion: %s ", osVersion));

    System.out.println(String.format("userHome: %s ", userHome));
    System.out.println(String.format("userConfigPath: %s ", getConfigPath()));
    System.out.println(String.format("osTempDir: %s ", TempDir));
    System.out.println(String.format("cwd: %s ", cwd));

  }
}
