package org.example.cli;

import java.util.HashMap;
import java.util.Map;

import org.example.config.ConfigClass;

public class CLI_Interface {
  ConfigClass Settings;
  Map<String, CommandHandler> CommandList = new HashMap<String, CommandHandler>();

  public CLI_Interface(ConfigClass settings) {
    Settings = settings;
  }

  public int runCommand(String cmdName, String[] args) {
    try {
      CommandHandler cmd = CommandList.get(cmdName);
      if (cmd != null) {
        cmd.run(args, Settings);
        return 0;
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
    return 1;
  }

}
