package game;

import java.util.Scanner;

/**
 * Game instance
 * @author Mazedias
 */
public class Game {
    private boolean running;
    private MisterX misterX;

    /**
     * Contructor
     */
    public Game() {
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

            this.executeCommand(userInput);
        }
        input.close();
    }

    private void executeCommand(String command) {
        switch(command) {
            case "addEdge":
                // TODO
            case "quit":
                this.endGame();
                break;
            default:
                this.InvalidInput();
                break;
        }
    }

    /**
     * This methods checks the user input
     * @param input User input
     * @return Returns the validity of the input
     * @throws InvalidInput Is thrown when a invalid input is detected
     */
    private boolean checkInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return false;
        }

        return true;
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
