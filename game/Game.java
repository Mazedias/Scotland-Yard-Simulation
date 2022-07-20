package game;

import java.util.Scanner;

import game.commands.Command;
import game.commands.CommandContainer;
import game.exceptions.InvalidInput;
import game.exceptions.UnknownCommand;

/**
 * Game class
 * @author Mazedias
 */
public class Game {
    
    private static final String commandSeperator = " ";
    private static CommandContainer commandContainer;
    private boolean running;
    private MisterX misterX;

    /**
     * Contructor
     */
    public Game() {
        commandContainer = new CommandContainer();
        
        this.running = true;
        this.misterX = new MisterX();
    }

    /**
     * Start a game
     */
    public void startGame() {
        Scanner input = new Scanner(System.in);
        while(running) {
            String userInput = input.nextLine();

            if (!this.checkInput(userInput)) {
                this.InvalidInput();
                continue;
            }

            // Call execute method
            this.executeCommand(userInput.split(commandSeperator)[0], userInput);
        }
        input.close();
    }

    /**
     * Executes the command
     * @param commandPrefix The prefix of the command
     * @param commandArguments Arguments of the command
     * @throws game.exceptions.InvalidInput
     */
    private void executeCommand(String commandPrefix, String userInput) {
        try {

            Command command = commandContainer.findeCommand(commandPrefix);
            this.checkArguments(command, userInput);
            command.executeCommand(userInput.split(commandSeperator));

        } catch (UnknownCommand | InvalidInput ex) {
            System.out.println(ex.toString());
        }
        
    }

    /**
     * This methods checks the user input
     * @param input User input
     * @return Returns the validity of the input
     */
    private boolean checkInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return false;
        }

        return true;
    }

    /**
     * Checks the user input for the correct amount of arguments
     * @param command The command that is to be executed
     * @param userInput The user input
     * @throws InvalidInput Is thrown if the amount of arguments is invalid
     */
    private void checkArguments(Command command, String userInput) throws InvalidInput {

        if (userInput.split(commandSeperator).length - 1 != command.getArgumentsAmount()) {
            throw new InvalidInput("invalid amount of arguments");
        }

    }

    /**
     * Sets the running variable to false to break the game loop
     */
    private void endGame() {
        this.running = false;
    }

    /**
     * Error message for invalid input
     */
    private void InvalidInput() {
        System.out.println("Error, invalid input");
    }

}
