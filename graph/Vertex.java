package graph;

/**
 * A Vertex of the graph
 * @author Mazedias
 */
public class Vertex {
    private int id;

    /**
     * Constructor
     * @param id Vertex ID
     */
    public Vertex (int id) {
        this.id = id;
    }

    /**
     * Returns the ID of the vertex
     * @return Vertex ID
     */
    public int getID() {
        return this.id;
    }

    /**
     * Overwritten equals method.
     * Vertices get compared by their ID
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex)) {
            return false;
        }

        Vertex v = (Vertex) o;

        if (v.getID() == this.id) {
            return true;
        }
        return false;
    }
}