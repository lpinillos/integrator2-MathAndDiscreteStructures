package com.example.integradora2discretas.DFSMatrix;

public class DFS {

    public void DFS(int[][] matrix, int position){
        int[] color = new int[matrix.length];
        int[] father = new int[matrix.length];
        int[] distance = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            color[i] = 0;
            father[i] = -1;
            distance[i] = -1;
        }
        DFSVisit(matrix, position, color, father, distance);
    }

    private void DFSVisit(int[][] matrix, int position, int[] color, int[] father, int[] distance){
        color[position] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[position][i] == 1 && color[i] == 0){
                father[i] = position;
                distance[i] = distance[position] + 1;
                DFSVisit(matrix, i, color, father, distance);
                System.out.println(i);
            }
        }
        color[position] = 2;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        int[][] matrix = new int[5][5];
        matrix[3][0] = 1;
        matrix[0][1] = 1;
        matrix[1][2] = 1;
        matrix[2][1] = 1;
        matrix[1][4] = 1;
        matrix[4][3] = 1;
        dfs.DFS(matrix, 0);
    }


}
