package graph;

public class Vertex {
    private int id;

    Vertex (int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

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