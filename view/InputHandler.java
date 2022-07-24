package view;

import model.Program;

import java.util.Scanner;

/**
 * This class handles user input
 * @author Mazedias
 */
public class InputHandler {

    private static final String COMMAND_SEPARATOR = " ";
    private final Program program;

    public InputHandler() {
        this.program = new Program();
    }

    /**
     * Gets user input for the program
     */
    public void getInput() {
        Scanner input = new Scanner(System.in);

        while(this.program.isRunning()) {
            String userInput = input.nextLine();

            if (!this.validateInput(userInput))  {
                this.invalidInput();
                continue;
            }

            this.evaluateInput(userInput);
        }

        input.close();
    }

    /**
     * Evaluates the user input
     * @param input User input
     */
    private void evaluateInput(String input) {
        String[] dividedInput = input.split(COMMAND_SEPARATOR);

        this.program.executeCommand(dividedInput[0], input);
    }

    /**
     * Checks for empty input
     * @param input User input
     * @return Returns validation result
     */
    private boolean validateInput(String input) {
        return !input.isEmpty() && !input.isBlank();
    }

    private void invalidInput() {
        System.out.println("Error, invalid input");
    }
}
