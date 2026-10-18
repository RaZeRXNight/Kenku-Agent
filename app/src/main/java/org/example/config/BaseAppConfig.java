package org.example.config;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * BaseAppConfig
 *
 * The Base class of AppConfig
 * Houses the underlying logic used by the Class.
 */
class BaseAppConfig {

  // Operating System Information
  private final String osName = System.getProperty("os.name");
  private final String osArch = System.getProperty("os.arch");
  private final String osVersion = System.getProperty("os.version");

  // File Paths
  private final FileSystem fs = FileSystems.getDefault();
  private final String configName = "KenkuAgent";

  private final Path userHome = fs.getPath(System.getProperty("user.home"));
  private final Path TempDir = fs.getPath(System.getProperty("java.io.tmpdir"));
  protected final Path cwd = fs.getPath(System.getProperty("user.dir"));
  protected final ObjectMapper myMapper = new ObjectMapper();

  private Path ConfigPath;

  /**
   * Constructor
   */
  public BaseAppConfig() {
    // Gracefully Exit program if user is on an Unsupported Operating System.
    if (getConfigPath() != 0) {
      System.out.println("ERROR: Operating System Unsupported");
      System.exit(1);
    }

    if (VerifyConfig() != 0) {
      System.out.println(
          String.format("ERROR: Error in Parsing %s Config File",
              ConfigPath.toString()));
      System.exit(1);

    }
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

  /*
   * Sets the ConfigPath based on the operating system the user is using.
   * Utilizes Path Class from java.nio.file
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
   * @param newConfig
   * @return
   */
  protected int writeConfig(ConfigClass newConfig) {
    System.out.println(String.format("Writting to %s...", ConfigPath));

    try {
      myMapper.writeValue(ConfigPath.toFile(), newConfig);
      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  /**
   * @return ConfigClass Settings Object.
   */
  protected ConfigClass readConfig() {
    try (Scanner fileScanner = new Scanner(ConfigPath.toFile())) {
      String scannerOutput = "";

      // Iterate through lines of config file, appending to aggregator.
      while (fileScanner.hasNextLine()) {
        scannerOutput = String.join("", scannerOutput, fileScanner.nextLine());
      }

      // Parse the string for json data to map to the SettingsClass
      ConfigClass data = myMapper.readValue(scannerOutput, ConfigClass.class);

      return data;
    } catch (Exception e) {
      throw new RuntimeException(e);

    }

  }

  /**
   * @param file
   * @return ConfigClass Settings Object.
   */
  protected ConfigClass readConfig(File file) {
    try (Scanner fileScanner = new Scanner(file)) {
      String scannerOutput = "";

      // Iterate through lines of config file, appending to aggregator.
      while (fileScanner.hasNextLine()) {
        scannerOutput = String.join("", scannerOutput, fileScanner.nextLine());
      }

      // Parse the string for json data to map to the SettingsClass
      ConfigClass data = myMapper.readValue(scannerOutput, ConfigClass.class);
      return data;
    } catch (Exception e) {
      throw new RuntimeException(e);

    }

  }

  protected int VerifyConfig() {
    try {
      ConfigClass settings = readConfig();
      return 0;
    } finally {
      return 1;

    }
  }
}
