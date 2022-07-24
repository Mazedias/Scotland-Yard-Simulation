package model.graph;

import model.game.transportation.VehicleType;
import model.graph.exceptions.InvalidVertex;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * An edge of the graph
 * @author Mazedias
 */
public class Edge {

    private final Node firstNode;
    private final Node secondNode;
    private final List<VehicleType> transportationTypes;

    public Edge(Node firstNode, Node secondNode) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.transportationTypes = new ArrayList<>();
    }

    public boolean containsTransportationType(VehicleType transportationType) {
        return this.transportationTypes.contains(transportationType);
    }

    public void addTransportationType(VehicleType transportationType) {
        this.transportationTypes.add(transportationType);
    }

    public void removeTransportationType(VehicleType transportationType) {
        this.transportationTypes.remove(transportationType);
    }

    /**
     * Returns the destination of the edge
     * @param startNode Start node of the edge
     * @return Returns the destination node of this edge
     * @throws InvalidVertex Is thrown when this edge does not start/end at the given startNode
     */
    public Node findTarget(Node startNode) throws InvalidVertex {
        if (startNode.equals(firstNode)) {
            return this.secondNode;
        } else if (startNode.equals(secondNode)) {
            return this.firstNode;
        }
        throw new InvalidVertex("this edge does not start/end at the node " + startNode.toString());
    }

    public Node[] getNodes() {
        return new Node[]{this.firstNode, this.secondNode};
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Edge edge)) {
            return false;
        }

        return (edge.getNodes()[0].equals(this.firstNode) && edge.getNodes()[1].equals(this.secondNode))
                || (edge.getNodes()[0].equals(this.secondNode) && edge.getNodes()[1].equals(this.firstNode));
    }
}
