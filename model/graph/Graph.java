package model.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.graph.exceptions.InvalidVertex;

/**
 * This represents a graph
 * @author Mazedias
 */
public class Graph {
    private HashMap<Node, List<Edge>> adjList;
    private final String name;

    public Graph(String name) {
        this.name = name;
    }

    /**
     * Adds a node to the graph
     * @param node Node ID
     */
    public void addNode(Node node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Removes a vertex from the graph
     * @param node Node ID
     */
    public void removeNode(Node node) throws InvalidVertex {
        if (!(this.adjList.containsKey(node))) {
            throw new InvalidVertex("this graph does not contain the node " + node.toString());
        }

        this.adjList.get(node).forEach(this::removeEdge);
        this.adjList.remove(node);
    }

    /**
     * Adds an edge between two nodes
     * @param firstNode First node
     * @param secondNode Second node
     * @throws InvalidVertex Is thrown by an invalid node
     */
    public void addEdge(Node firstNode, Node secondNode) throws InvalidVertex {
        if (!(adjList.containsKey(firstNode) && adjList.containsKey(secondNode))) {
            throw new InvalidVertex("a node is not in the graph");
        }

        Edge edge = new Edge(firstNode, secondNode);

        adjList.get(firstNode).add(edge);
        adjList.get(secondNode).add(edge);
    }

    /**
     * Removes an edge between two nodes
     * @param firstNode First node
     * @param secondNode Second vertex
     * @throws InvalidVertex Is thrown by an invalid node
     */
    public void removeEdge(Node firstNode, Node secondNode) throws InvalidVertex {
        if (!(adjList.containsKey(firstNode) && adjList.containsKey(secondNode))) {
            throw new InvalidVertex("a vertex is not in the model.graph");
        }

        if (adjList.get(firstNode).isEmpty() || adjList.get(secondNode).isEmpty()) {
            throw new InvalidVertex("invalid vertex entry");
        }

        Edge edge = new Edge(firstNode, secondNode);

        // Remove the edge from both nodes in the adjList
        this.adjList.get(firstNode).forEach(e -> {
            if (e.equals(edge)) this.adjList.get(firstNode).remove(e);
        });
        this.adjList.get(secondNode).forEach(e -> {
            if (e.equals(edge)) this.adjList.get(secondNode).remove(e);
        });
    }

    /**
     * Removes an edge between two nodes
     * @param edge The edge to be removed
     */
    public void removeEdge(Edge edge) {
        try {
            this.removeEdge(edge.getNodes()[0], edge.getNodes()[1]);
        } catch (InvalidVertex e) {
            System.out.println("Error, " + e.toString());
        }
    }

    /**
     * Gets the name of the graph
     * @return The graph's name
     */
    public String getName() {
        return this.name;
    }
}
