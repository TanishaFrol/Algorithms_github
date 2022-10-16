package Graph;

public class MyGraphDemo {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 7);
        graph.addEdge("A", "C", 3);
        graph.addEdge("A", "D", 1);
        graph.addEdge("B", "G", 15);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "F", 4);
        graph.addEdge("E", "D", 8);
        graph.addEdge("E", "F", 2);
        graph.addEdge("E", "G", 1);
        graph.addEdge("F", "G", 6);
        System.out.println(graph);
        System.out.println();
        graph.dfs("A", System.out::print);
        System.out.println();
        graph.bfs("A", System.out::print);
        System.out.println();
        System.out.printf("The shortest path from %s to %s is: %d\n", "A", "G", graph.findShortestPath("A", "G"));
    }
}
