package graph.exceptions;

public class InvalidVertex extends Exception {

    public InvalidVertex(String message) {
        System.out.println("Error, " + message);
    }
    
}
