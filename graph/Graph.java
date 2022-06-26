package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import graph.exceptions.InvalidVertex;

/**
 * This represents a graph
 * @author Mazedias
 */
public class Graph {
    private HashMap<Vertex, List<Vertex>> adjVertice;
    private String name;

    Graph(String name) {
        this.name = name;
    }

    public void addVertex(int id) {
        adjVertice.putIfAbsent(new Vertex(id), new ArrayList<>());
    }

    public void removeVertex(int id) {
        Vertex v = new Vertex(id);
        adjVertice.values().stream().forEach(e -> e.remove(v));
        adjVertice.remove(new Vertex(id));
    }

    public void addEdge(int id1, int id2) throws InvalidVertex {
        Vertex v1 = new Vertex(id1);
        Vertex v2 = new Vertex(id2);

        if (!(adjVertice.containsKey(v1) && adjVertice.containsKey(v2))) {
            throw new InvalidVertex("a vertex is not in the graph");
        }

        adjVertice.get(v1).add(v2);
        adjVertice.get(v2).add(v1);
    }

    public void removeEdge(int id1, int id2) throws InvalidVertex {
        Vertex v1 = new Vertex(id1);
        Vertex v2 = new Vertex(id2);

        if (!(adjVertice.containsKey(v1) && adjVertice.containsKey(v2))) {
            throw new InvalidVertex("a vertex is not in the graph");
        }

        if (adjVertice.get(v1) == null || adjVertice.get(v2) == null) {
            throw new InvalidVertex("invalid vertex entry");
        }

        adjVertice.get(v1).remove(v2);
        adjVertice.get(v2).remove(v1);
    }


    public String getName() {
        return this.name;
    }
}
