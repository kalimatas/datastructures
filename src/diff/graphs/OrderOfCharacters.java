package diff.graphs;

import graph.DirectedGraph;

import java.util.LinkedList;
import java.util.Stack;

// Add chars to a graph, then find topological sorting of the graph
public class OrderOfCharacters {

    private static class Graph {
        int V;
        LinkedList<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            //noinspection unchecked
            adj = new LinkedList[V];

            for (int i = 0; i < V; i++)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].addLast(w);
        }

        void topologicalOrdering() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    topoUtil(i, visited, stack);

            // stack now contains the order
            while (!stack.isEmpty())
                System.out.printf("%c ", (char) ('a' + stack.pop()));
        }

        private void topoUtil(int v, boolean[] visited, Stack<Integer> stack) {
            // mark current vertex as visited
            visited[v] = true;

            // recur for all adjacent vertices
            for (int i : adj[v])
                if (!visited[i])
                    topoUtil(i, visited, stack);

            stack.push(v);
        }
    }

    public static void main(String[] args) {
        //String[] words = {"caa", "aaa", "aab"};
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 4);
    }

    static void printOrder(String[] words, int alpha) {
        //DirectedGraph g = new DirectedGraph();
        Graph g = new Graph(alpha);

        //for (int i = 0; i < alpha; i++) {
        //    g.addVertex((char)(i + 'a'));
        //}

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    g.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        try {
            g.topologicalOrdering();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
