package com.example.integradora2discretas.FloydList;

public class FloydWarshall {

        private int V;
        private int E;
        private int[][] dist;

        public FloydWarshall(int V) {
            this.V = V;
            this.E = 0;
            this.dist = new int[V][V];
        }

        public void addEdge(int u, int v, int w) {
            dist[u][v] = w;
            E++;
        }

        public void floydWarshall(){
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i != j && dist[i][j] == 0) {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        public void printDist(int s) {
            for (int i = 0; i < V; i++) {
                if (dist[s][i] == Integer.MAX_VALUE) {
                    System.out.println("No path from " + s + " to " + i + " exists.");
                } else {
                    System.out.println("Shortest path from " + s + " to " + i + " is " + dist[s][i]);
                }
            }
        }

        public static void main(String[] args) {
            FloydWarshall g = new FloydWarshall(6);
            g.addEdge(0, 1, 4);
            g.addEdge(0, 2, 2);
            g.addEdge(1, 0, 4);
            g.addEdge(1, 2, 1);
            g.addEdge(1, 3, 5);
            g.addEdge(2, 0, 2);
            g.addEdge(2, 1, 1);
            g.addEdge(2, 4, 10);
            g.addEdge(2, 3, 8);
            g.addEdge(3, 1, 5);
            g.addEdge(3, 2, 8);
            g.addEdge(3, 4, 2);
            g.addEdge(3, 5, 6);
            g.addEdge(4, 2, 10);
            g.addEdge(4, 3, 2);
            g.addEdge(4, 5, 3);
            g.addEdge(5, 3, 6);
            g.addEdge(5, 4, 3);

            g.floydWarshall();
            g.printDist(0);

        }



}
