package graph;

import linkedlist.StackLinkedList;
import stackqueue.QueueArray;

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
            System.out.printf("%s", label);
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

    private void resetIsVisited() {
        for (int i = 0; i < size; i++)
            vertexList[i].setVisited(false);
    }

    private int getAdjacentUnvisited(int vertex) {
        for (int i = 0; i < size; i++)
            if (adjMatrix[vertex][i] == 1 && !vertexList[i].isVisited)
                return i;

        return -1;
    }

    public void dfs() throws Exception {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();

        vertexList[0].setVisited(true);
        vertexList[0].display();
        stack.push(0);

        int adjVertex;
        while (!stack.isEmpty()) {
            adjVertex = getAdjacentUnvisited(stack.peek());
            if (adjVertex == -1) {
                stack.pop();
            } else {
                vertexList[adjVertex].setVisited(true);
                vertexList[adjVertex].display();
                stack.push(adjVertex);
            }
        }

        resetIsVisited();
        System.out.println();
    }

    public void bfs() {
        QueueArray<Integer> queue = new QueueArray<Integer>(MAX_VERTS);

        vertexList[0].setVisited(true);
        vertexList[0].display();
        queue.insert(0);

        int vertex, adjVertex;
        while (!queue.isEmpty()) {
            vertex = queue.remove();
            while ((adjVertex = getAdjacentUnvisited(vertex)) != -1) {
                vertexList[adjVertex].setVisited(true);
                vertexList[adjVertex].display();
                queue.insert(adjVertex);
            }
        }

        resetIsVisited();
        System.out.println();
    }

    /**
     * Create a minimum spanning tree with DFS.
     */
    public void mst() throws Exception {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();

        vertexList[0].setVisited(true);
        stack.push(0);

        int vertex, adjVertex;

        while (!stack.isEmpty()) {
            vertex = stack.peek();
            adjVertex = getAdjacentUnvisited(vertex);
            if (adjVertex == -1) {
                stack.pop();
            } else {
                vertexList[adjVertex].setVisited(true);
                stack.push(adjVertex);

                vertexList[vertex].display();
                vertexList[adjVertex].display();
                System.out.print(' ');
            }
        }

        resetIsVisited();
        System.out.println();
    }
}
