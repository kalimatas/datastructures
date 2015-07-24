package graph;

import linkedlist.StackLinkedList;

import java.util.Arrays;

public class DirectedGraph {

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
            System.out.printf("%s", label);
        }
    }

    private static int MAX_VERTS = 20;
    private int size;
    private Vertex[] vertexList = new Vertex[MAX_VERTS];
    private int[][] adjMatrix = new int[MAX_VERTS][MAX_VERTS];

    // For topological ordering
    private int topoSize;
    private Vertex[] topoVertexList;
    private int[][] topoAdjMatrix;

    public DirectedGraph() {
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
    }

    public void topologicalOrdering() throws Exception {
        StackLinkedList<Character> stack = new StackLinkedList<Character>();

        // copy data
        topoSize = size;
        topoVertexList = Arrays.copyOf(vertexList, size);
        topoAdjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            topoAdjMatrix[i] = Arrays.copyOf(adjMatrix[i], size);
        }

        while (topoSize > 0) {
            int vertex = noSuccessors();
            if (vertex == -1) {
                throw new Exception("Graph has cycles");
            }

            stack.push(topoVertexList[vertex].label);
            deleteVertex(vertex);
        }

        // display
        while (!stack.isEmpty()) {
            System.out.printf("%s", stack.pop());
        }
        System.out.println();
    }

    private int noSuccessors() {
        boolean hasConnection;

        for (int i = 0; i < topoSize; i++) {
            hasConnection = false;
            for (int j = 0; j < topoSize; j++) {
                if (topoAdjMatrix[i][j] == 1) {
                    hasConnection = true;
                    break;
                }
            }

            if (!hasConnection) {
                return i;
            }
        }

        return -1;
    }

    private void deleteVertex(int vertex) {
        int size = topoSize - 1;

        if (vertex != size) {
            for (int i = vertex; i < size; i++) {
                topoVertexList[i] = topoVertexList[i + 1];
            }

            for (int row = vertex; row < size; row++)
                moveRowUp(row, topoSize);

            for (int col = vertex; col < size; col++)
                moveColLeft(col, size);
        }

        --topoSize;
    }

    private void moveRowUp(int row, int size) {
        for (int col = 0; col < size; col++)
            topoAdjMatrix[row][col] = topoAdjMatrix[row + 1][col];
    }

    private void moveColLeft(int col, int size) {
        for (int row = 0; row < size; row++) {
            topoAdjMatrix[row][col] = topoAdjMatrix[row][col + 1];
        }
    }

    private void displayAdjMatrix() {
        System.out.println();

        System.out.print("  ");
        for (int i = 0; i < topoSize; i++)
            System.out.printf("%s ", topoVertexList[i].label);

        System.out.println();

        for (int i = 0; i < topoSize; i++) {
            System.out.printf("%s ", topoVertexList[i].label);

            for (int j = 0; j < topoSize; j++)
                System.out.printf("%d ", topoAdjMatrix[i][j]);

            System.out.println();
        }
        System.out.println();
    }
}

