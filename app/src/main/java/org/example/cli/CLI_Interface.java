package org.example.cli;

import org.example.config.ConfigClass;
import java.util.Map;
import java.util.HashMap;

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
