package graph;

public class WeightedDirectedGraph {

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

    private class DistancePair {
        private int parentVertex;
        private int distance;

        DistancePair(int vertex, int d) {
            parentVertex = vertex;
            distance = d;
        }

        int getDistance() { return distance; }
        int getParentVertex() { return parentVertex; }
    }

    private static int MAX_VERTS = 20;
    private static int INFINITY = 20000;
    private int size;
    private Vertex[] vertexList = new Vertex[MAX_VERTS];
    private int[][] adjMatrix = new int[MAX_VERTS][MAX_VERTS];
    private DistancePair[] sPath = new DistancePair[MAX_VERTS];

    public WeightedDirectedGraph() {
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
    }

    private void resetIsInTree() {
        for (int i = 0; i < size; i++)
            vertexList[i].setIsInTree(false);
    }

    public void path() {
        int currentVertex = 0;
        vertexList[currentVertex].setIsInTree(true);
        int nVerts = 1;

        // initial shortest-path array
        for (int i = 0; i < size; i++) {
            sPath[i] = new DistancePair(currentVertex, adjMatrix[currentVertex][i]);
        }

        int minDistanceVertex,
            minDistance;

        while (nVerts < size) {
            minDistanceVertex = getMinDistanceVertex();
            minDistance = sPath[minDistanceVertex].getDistance();

            if (minDistance == INFINITY) {
                System.out.println("Unreachable vertices");
                break;
            } else {
                currentVertex = minDistanceVertex;
            }

            vertexList[currentVertex].setIsInTree(true);
            nVerts++;
            adjustShortestPath(currentVertex, minDistance);
        }

        displayShortestPath();
        resetIsInTree();
    }

    private int getMinDistanceVertex() {
        int minDistance = INFINITY;
        int minIndex = 0;

        for (int i = 1; i < size; i++) {
            if (!vertexList[i].getIsInTree() && sPath[i].getDistance() < minDistance) {
                minDistance = sPath[i].getDistance();
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void adjustShortestPath(int currentVertex, int distanceFromStart) {
        // Sets the distances from the starting vertex via currenvVertex

        int distance, shortestPathDistance;

        int column = 1; // skip starting vertex
        while (column < size) {
            // skip if in tree
            if (!vertexList[column].getIsInTree()) {
                distance = distanceFromStart + adjMatrix[currentVertex][column];
                shortestPathDistance = sPath[column].getDistance();

                if (distance < shortestPathDistance) {
                    sPath[column] = new DistancePair(currentVertex, distance);
                }
            }
            column++;
        }
    }

    private void displayShortestPath() {
        for (int i = 0; i < size; i++) {
            DistancePair dp = sPath[i];

            System.out.printf("%s=%s(%s) ",
                    vertexList[i].label,
                    dp.getDistance() == INFINITY ? "inf" : dp.getDistance(),
                    vertexList[dp.getParentVertex()].label
            );
        }
        System.out.println();
    }
}
