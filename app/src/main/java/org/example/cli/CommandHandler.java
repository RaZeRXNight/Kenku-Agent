package org.example.cli;

import org.example.config.ConfigClass;

public interface CommandHandler {
  public final String cmdName = "";
  public final String cmdDescription = "";

  void run(String[] args, ConfigClass Settings);

  default public String describe() {
    return String.join(": ", cmdName, cmdDescription);
  }
}
