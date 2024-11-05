package io.natewilcox;

import java.util.HashMap;
import java.util.Map;

public class ArgParser {

    public ArgParser(String[] args, Builder builder) {

        String commandInput = args.length >= 1 ? args[0] : "help";
        Command command = builder.commands.get(commandInput);

        if(command != null) {
            command.execute();
        }
    }

    public static class Builder {

        private Map<String, Command> commands = new HashMap<>();

        public Builder on(String arg, Command command) {
            
            this.commands.put(arg, command);
            return this;
        }

        public ArgParser execute(String[] args) {
            
            return new ArgParser(args, this);
        }
    }
}
