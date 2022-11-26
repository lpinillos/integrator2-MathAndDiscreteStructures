package com.example.integradora2discretas.FloydMatrix;

public class Floyd {

    // Make Floyd warshall algorithm with adjacency matrix

    public static void floyd(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];
        int[][] next = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != Integer.MAX_VALUE && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, 8, Integer.MAX_VALUE, -4},
            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 1, 7},
            {Integer.MAX_VALUE, 4, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {2, Integer.MAX_VALUE, -5, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0}
        };
        floyd(graph);
    }

}
