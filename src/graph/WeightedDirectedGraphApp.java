package graph;

public class WeightedDirectedGraphApp {
    public static void main(String[] args) {
        WeightedDirectedGraph graph = new WeightedDirectedGraph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1, 50);
        graph.addEdge(0, 3, 80);
        graph.addEdge(1, 2, 60);
        graph.addEdge(1, 3, 90);
        graph.addEdge(2, 4, 40);
        graph.addEdge(3, 2, 20);
        graph.addEdge(3, 4, 70);
        graph.addEdge(4, 1, 50);

        System.out.println("shortest paths: ");
        graph.path();
    }
}

