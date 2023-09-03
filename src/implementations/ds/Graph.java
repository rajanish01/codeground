package implementations.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int vertices;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int start, int end) {
        this.adj.get(start).add(end);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");

            for (int i = 0; i < adj.get(n).size(); i++) {
                int node = adj.get(n).get(i);
                if (!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    private void DFSUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < adj.get(start).size(); i++) {
            int n = adj.get(start).get(i);
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[this.vertices];
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);

        graph.BFS(0);
        System.out.println();
        graph.DFS(0);
    }


}
