package graph;

public class Graph {

    private class Vertex {
        private char label;
        private boolean isVisited;

        private Vertex(char label) {
            this.label = label;
        }

        private void setVisited(boolean flag) {
            isVisited = flag;
        }

        private void display() {
            System.out.println(label);
        }
    }

    private static int MAX_VERTS = 20;
    private int size;
    private Vertex[] vertexList = new Vertex[MAX_VERTS];
    private int[][] adjMatrix = new int[MAX_VERTS][MAX_VERTS];

    public Graph() {
        for (int i = 0; i < MAX_VERTS; i++)
            for (int j = 0; j < MAX_VERTS; j++)
                adjMatrix[i][j] = 0;
    }

    public void addVertex(char label) {
        if (size == MAX_VERTS) throw new IllegalStateException("Max number of vertices is reached");
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int from, int to) {
        if (from >= MAX_VERTS || to >= MAX_VERTS) throw new IndexOutOfBoundsException();

        adjMatrix[from][to] = 1;
        adjMatrix[to][from] = 1;
    }

}
