package Graph;

public interface Graph {

    boolean addVertex(String label);

    boolean addEdge(String from, String to, int weight);
}
