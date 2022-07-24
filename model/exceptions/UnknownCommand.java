package model.exceptions;

public class UnknownCommand extends Exception{

    public UnknownCommand() {
        System.out.println("Error, unknown command!");
    }

}
