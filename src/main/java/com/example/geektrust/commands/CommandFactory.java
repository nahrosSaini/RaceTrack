package com.example.geektrust.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String,Command> inputCommands=new HashMap<>();

    {
        inputCommands.put("BOOK",new BookCommand());
        inputCommands.put("ADDITIONAL",new AdditionalCommand());
        inputCommands.put("REVENUE",new RevenueCommand());
    }

    public Command getCommand(String command){
         return inputCommands.get(command);
    }

}
