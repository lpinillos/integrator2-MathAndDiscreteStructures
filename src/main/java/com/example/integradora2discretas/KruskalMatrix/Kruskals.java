package com.example.integradora2discretas.KruskalMatrix;

public class Kruskals {

    // Make Kruskals algorithm work with matrix instead of lists

    public static int Kruskals(int[][] g) {
        int totalWeight = 0;
        int[] nodes = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < g.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < g.length; j++) {
                if (g[j][j] < min) {
                    min = g[j][j];
                    minIndex = j;
                }
            }
            if (nodes[g[minIndex][0] - 1] != nodes[g[minIndex][1] - 1]) {
                int temp = nodes[g[minIndex][1] - 1];
                for (int j = 0; j < nodes.length; j++) {
                    if (nodes[j] == temp) {
                        nodes[j] = nodes[g[minIndex][0] - 1];
                    }
                }
                totalWeight += g[minIndex][2];
            }
            g[minIndex][2] = Integer.MAX_VALUE;
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        int[][] g = {{1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 4},
                {4, 5, 5},
                {3, 5, 7}};
        System.out.println(Kruskals(g));
    }



}
