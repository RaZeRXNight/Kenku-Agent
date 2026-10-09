package org.example.config;

public class AppConfig {
  private String osName = System.getProperty("java.version");
  private String userHome = System.getProperty("user.home");
  private String osTempDir = System.getProperty("java.io.tmpdir");
  private String cwd = System.getProperty("user.dir");
  private String fileSeparator = System.getProperty("file.separator");
  private String pathSeparator = System.getProperty("path.separator");

  public void outputProgramEnv() {
    System.out.println(String.format("osName: ", osName));
    System.out.println(String.format("userHome: ", userHome));
    System.out.println(String.format("osTempDir: ", osTempDir));
    System.out.println(String.format("cwd: ", cwd));
    System.out.println(String.format("fileSeparator: ", fileSeparator));
    System.out.println(String.format("pathSeparator: ", pathSeparator));
  }
}
