package game;

import graph.Vertex;

/**
 * Abstract player class
 * @author Mazedias
 */
public abstract class Player {
    private Vertex location;

    /**
     * Update the location of the Player
     * @param location New location of the player
     */
    protected void updateLocation(Vertex location) {
        this.location = location;
    }

    /**
     * Get the location of the player
     * @return Returns the location
     */
    public Vertex getLocation() {
        return this.location;
    }
}
