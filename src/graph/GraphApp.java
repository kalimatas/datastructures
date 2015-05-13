package graph;

public class GraphApp {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.print("DFS: ");
        graph.dfs();

        System.out.print("BFS: ");
        graph.bfs();

        System.out.print("MST: ");
        graph.mst();
    }
}
