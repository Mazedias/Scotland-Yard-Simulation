package model.exceptions;

/**
 * Exception for invalid command arguments
 * @author Mazdias
 */
public class InvalidArguments extends Throwable {

    public InvalidArguments(String message) {
        System.out.println("Error, " + message);
    }

}
