package game.commands;

import java.util.ArrayList;
import java.util.List;

import game.exceptions.UnknownCommand;

/**
 * This class holds all commands
 * @author Mazedias
 */
public class CommandContainer {
    
    private List<Command> commands;

    public CommandContainer() {
        this.commands = new ArrayList<>();
    }

    /**
     * Command finder
     * @param input User input
     * @throws UnknownCommand Is thrown when the user enters a unregistered command
     */
    public Command findeCommand(String input) throws UnknownCommand {
        for(Command command : this.commands) {
            if (command.getName().equalsIgnoreCase(input)) {
                return command;
            }
        }
        throw new UnknownCommand();
    }

    /**
     * Register a command
     * @param command New command
     */
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    /**
     * Unregister a command
     * @param command Command to unregist
     * @throws UnknownCommand Is thrown when the command is not registered
     */
    public void unregisterCommand(Command command) throws UnknownCommand {
        if (this.commands.contains(command)) {
            this.commands.remove(command);
        }
        throw new UnknownCommand();
    }
}
