package org.example.config;

import com.sun.java.swing.action.ExitAction;

public class AppConfig {

  // Operating System Information
  private String osName = System.getProperty("os.name");
  private String osArch = System.getProperty("os.arch");
  private String osVersion = System.getProperty("os.version");

  // File Paths
  private String userHome = System.getProperty("user.home");
  private String TempDir = System.getProperty("java.io.tmpdir");
  private String cwd = System.getProperty("user.dir");
  private String configName = "KenkuAgent";

  // File System Properties
  private String fileSeparator = System.getProperty("file.separator");
  private String pathSeparator = System.getProperty("path.separator");

  AppConfig() {
    // Gracefully Exit program is user is on an Unsupported Operating System.
    if (getConfigPath().isBlank()) {
      System.out.println("Operating System Unsupported");
      System.exit(1);
    }
  }

  /**
   * @return The File Path to the user's Configuration Settings.
   */
  protected String getConfigPath() {
    switch (osName) {
      case "Linux":
        return String.join(fileSeparator, userHome, ".config", configName);
      case "Windows":
        return "";
      case "Mac":
        return "";
      default:
        return "";
    }
  }

  public int setConfigValue() {
    return 0;
  }

  public String getConfigValue() {
    return "";
  }

  public void outputProgramEnv() {
    System.out.println(String.format("osName: %s", osName));
    System.out.println(String.format("osArch: %s ", osArch));
    System.out.println(String.format("osVersion: %s ", osVersion));

    System.out.println(String.format("userHome: %s ", userHome));
    System.out.println(String.format("userConfigPath: %s ", getConfigPath()));
    System.out.println(String.format("osTempDir: %s ", TempDir));
    System.out.println(String.format("cwd: %s ", cwd));

    // System.out.println(String.format("fileSeparator: %s ", fileSeparator));
    System.out.println(String.format("pathSeparator: %s ", pathSeparator));
  }
}
