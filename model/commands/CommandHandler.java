package model.commands;

import model.Program;
import model.exceptions.InvalidArguments;
import model.exceptions.UnknownCommand;

import java.util.Arrays;

/**
 * Handles all commands
 * @author Mazedias
 */
public class CommandHandler {

    private static final CommandContainer commandContainer = new CommandContainer();
    private static final String COMMAND_SEPARATOR = " ";

    public Command getCommand(String commandPrefix) throws UnknownCommand {
        return commandContainer.findCommand(commandPrefix);
    }

    /**
     * Every command must be registered here
     * @param program Instance of {@link Program}
     */
    public void registerCommands(Program program) {
        commandContainer.registerCommand(new Quit(program));
    }

    /**
     * Checks the given arguments
     * @param command Entered command
     * @param userInput User input
     * @throws InvalidArguments Is thrown when an invalid argument is detected
     */
    public void checkArguments(Command command, String userInput) throws InvalidArguments {
        if (command.getArgumentsAmount() < 1) {
            return;
        }

        String[] args = Arrays.copyOfRange(userInput.split(COMMAND_SEPARATOR),
                1, userInput.split(COMMAND_SEPARATOR).length - 1);

        if (command.getArgumentsAmount() != args.length) {
            throw new InvalidArguments("invalid amount of arguments");
        }

        for (String arg : args) {
            if (arg.isEmpty() || arg.isBlank()) {
                throw new InvalidArguments("invalid argument detected");
            }
        }
    }
}
