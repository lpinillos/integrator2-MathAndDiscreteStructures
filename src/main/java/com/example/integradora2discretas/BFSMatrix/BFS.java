package com.example.integradora2discretas.BFSMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    // Make BFS with matrix adjacency list and return the result

    public static String[] BFSMatrixAdjacencyList(int[][] matrix, int position){
        if(matrix.length > 0){
            String[] result = new String[matrix.length];
            int[] color = new int[matrix.length];
            int[] distance = new int[matrix.length];
            int[] father = new int[matrix.length];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < matrix.length; i++) {
                color[i] = 0;
                distance[i] = 0;
                father[i] = -1;
            }
            color[position] = 1;
            distance[position] = 0;
            father[position] = -1;
            queue.add(position);
            int i = 0;
            while(!queue.isEmpty()){
                int u = queue.remove();
                for (int j = 0; j < matrix.length; j++) {
                    if(matrix[u][j] == 1){
                        if(color[j] == 0){
                            color[j] = 1;
                            distance[j] = distance[u] + 1;
                            father[j] = u;
                            queue.add(j);
                        }
                    }
                }
                color[u] = 2;
                result[i] = Integer.toString(u);
                i++;
            }
            return result;
        } else {
            System.out.println("Matrix is empty");
            return null;
        }
    }

    // Make main

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0, 0, 0},
                          {0, 0, 1, 0, 1, 0},
                          {0, 1, 0, 0, 0, 0},
                          {1, 0, 0, 0, 0, 0},
                          {0, 0, 0, 1, 0, 0},
                          {0, 0, 0, 0, 0, 0}};
        String[] result = BFSMatrixAdjacencyList(matrix, 0);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }





}
