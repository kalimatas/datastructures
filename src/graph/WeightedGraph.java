package graph;

import stackqueue.PriorityQueueArray;

public class WeightedGraph {

    private class Vertex {
        private char label;
        private boolean isInTree;

        private Vertex(char label) {
            this.label = label;
        }

        private void setIsInTree(boolean flag) {
            isInTree = flag;
        }

        private boolean getIsInTree() {
            return isInTree;
        }

        private void display() {
            System.out.printf("%s", label);
        }
    }

    private class Edge implements Comparable<Edge> {
        private int sourceVertex;
        private int destinationVertex;
        private int weight;

        private Edge(int src, int dst, int w) {
            sourceVertex = src;
            destinationVertex = dst;
            weight = w;
        }

        private int getSourceVertex() {
            return sourceVertex;
        }

        private int getDestinationVertex() {
            return destinationVertex;
        }

        private int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.getWeight();
        }
    }

    private class PriorityQueue extends PriorityQueueArray {
        public PriorityQueue(int maxSize) {
            super(maxSize);
        }

        public Edge remove() {
            return (Edge) super.remove();
        }

        public int find(int destinationVertex) {
            for (int i = 0; i < size; i++)
                if (peekAt(i).getDestinationVertex() == destinationVertex) return i;

            return -1;
        }

        public Edge peekAt(int n) {
            return (Edge) items[n];
        }

        public void removeAt(int n) {
            for (int i = n; i < size - 1; i++)
                items[i] = items[i + 1];

            --size;
        }
    }

    private static int MAX_VERTS = 20;
    private static int INFINITY = 20000;
    private int size;
    private Vertex[] vertexList = new Vertex[MAX_VERTS];
    private int[][] adjMatrix = new int[MAX_VERTS][MAX_VERTS];
    private PriorityQueue pQueue = new PriorityQueue(MAX_VERTS);

    public WeightedGraph() {
        for (int i = 0; i < MAX_VERTS; i++)
            for (int j = 0; j < MAX_VERTS; j++)
                adjMatrix[i][j] = INFINITY;
    }

    public void addVertex(char label) {
        if (size == MAX_VERTS) throw new IllegalStateException("Max number of vertices is reached");
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int from, int to, int weight) {
        if (from >= MAX_VERTS || to >= MAX_VERTS) throw new IndexOutOfBoundsException();

        adjMatrix[from][to] = weight;
        adjMatrix[to][from] = weight;
    }

    private void resetIsInTree() {
        for (int i = 0; i < size; i++)
            vertexList[i].setIsInTree(false);
    }

    public void mstw() {
        int nVerts = 0;
        int currentVertex = 0;

        // Minimum spanning tree has N - 1 edges
        while (nVerts < size - 1) {
            // Put the vertex in a tree
            vertexList[currentVertex].setIsInTree(true);
            nVerts++;

            for (int i = 0; i < size; i++) {
                if (currentVertex == i) continue;
                if (vertexList[i].getIsInTree()) continue;

                int weight = adjMatrix[currentVertex][i];
                if (weight == INFINITY) continue; // no edge

                putInQueue(currentVertex, i, weight);
            }

            if (pQueue.size() == 0) {
                System.out.println("Graph is not connected");
                return;
            }

            // Get the minimum edge
            Edge min = pQueue.remove();
            int sourceVertex = min.getSourceVertex();
            currentVertex = min.getDestinationVertex();

            vertexList[sourceVertex].display();
            vertexList[currentVertex].display();
            System.out.print(' ');
        }

        resetIsInTree();
        System.out.println();
    }

    private void putInQueue(int currentVertex, int destinationVertex, int weight) {
        Edge newEdge = new Edge(currentVertex, destinationVertex, weight);
        int position = pQueue.find(destinationVertex);
        if (position == -1) {
            pQueue.insert(newEdge);
        } else {
            Edge tmp = pQueue.peekAt(position);
            if (newEdge.getWeight() < tmp.getWeight()) {
                pQueue.removeAt(position);
                pQueue.insert(newEdge);
            }
        }
    }
}
