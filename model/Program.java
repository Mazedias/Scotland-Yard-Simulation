package model;

import model.commands.Command;
import model.commands.CommandHandler;
import model.exceptions.InvalidArguments;
import model.exceptions.UnknownCommand;

/**
 * Interface between view and model
 * @author Mazedias
 */
public class Program {

    private static final CommandHandler commandHandler = new CommandHandler();
    private boolean running;

    public Program() {
        this.running = true;
        commandHandler.registerCommands(this);
    }

    /**
     * Executes a command
     * @param commandPrefix Prefix of a command
     * @param args Command arguments
     */
    public void executeCommand(String commandPrefix, String userInput) {
        try {
            Command command = commandHandler.getCommand(commandPrefix);
            commandHandler.checkArguments(command, userInput);

            command.executeCommand(userInput);
        } catch (UnknownCommand | InvalidArguments ex) {
            System.out.println(ex.toString());
        }
    }

    public void endProgram() {
        this.running = false;
    }

    public boolean isRunning() {
        return this.running;
    }
}
