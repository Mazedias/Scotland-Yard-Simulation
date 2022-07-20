package game.exceptions;

public class InvalidInput extends Exception{

    public InvalidInput(String message) {
        System.out.println("Error, " + message);
    }

}
