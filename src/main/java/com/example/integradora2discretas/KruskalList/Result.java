package com.example.integradora2discretas.KruskalList;

import java.util.List;

public class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */



    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    // This is the solution I came up with. It's not the best solution, but it works.

    public static int Kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int totalWeight = 0;
        int[] nodes = new int[gNodes];
        for (int i = 0; i < gNodes; i++) {
            nodes[i] = i;
        }
        for (int i = 0; i < gFrom.size(); i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < gFrom.size(); j++) {
                if (gWeight.get(j) < min) {
                    min = gWeight.get(j);
                    minIndex = j;
                }
            }
            if (nodes[gFrom.get(minIndex) - 1] != nodes[gTo.get(minIndex) - 1]) {
                int temp = nodes[gTo.get(minIndex) - 1];
                for (int j = 0; j < nodes.length; j++) {
                    if (nodes[j] == temp) {
                        nodes[j] = nodes[gFrom.get(minIndex) - 1];
                    }
                }
                totalWeight += gWeight.get(minIndex);
            }
            gWeight.set(minIndex, Integer.MAX_VALUE);
        }
        return totalWeight;
    }




}
