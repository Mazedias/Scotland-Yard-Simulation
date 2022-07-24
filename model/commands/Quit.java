package model.commands;

import model.Program;

/**
 * Quit command
 * @author Mazedias
 */
public class Quit extends Command{

    private final Program program;

    public Quit(Program program) {
        this.program = program;

        this.commandName = "quit";
        this.args = 0;
    }

    @Override
    public void executeCommand(String userInput) {
        this.program.endProgram();
    }
}
