package model.graph;

import model.game.transportation.VehicleType;

import java.util.List;

/**
 * A node of the graph
 * @author Mazedias
 */
public class Node {
    private final int id;
    private List<VehicleType> stationTypes;

    public Node(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of the vertex
     * @return Node ID
     */
    public int getID() {
        return this.id;
    }

    /**
     * Overwritten equals method.
     * Vertices get compared by their ID
     */
    public boolean containsTransportationType(VehicleType transportationType) {
        return this.stationTypes.contains(transportationType);
    }

    public void addTransportationType(VehicleType transportationType) {
        this.stationTypes.add(transportationType);
    }

    public void removeTransportationType(VehicleType transportationType) {
        this.stationTypes.remove(transportationType);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node node)) {
            return false;
        }

        return node.getID() == this.id;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }

}