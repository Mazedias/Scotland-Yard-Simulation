package model.game.user_objects;

import model.graph.Node;

/**
 * Abstract user_objects class
 * @author Mazedias
 */
public abstract class Player {
    private Node location;

    /**
     * Update the location of the Player
     * @param location New location of the user_objects
     */
    protected void updateLocation(Node location) {
        this.location = location;
    }

    /**
     * Get the location of the user_objects
     * @return Returns the location
     */
    public Node getLocation() {
        return this.location;
    }
}
