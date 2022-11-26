package com.example.integradora2discretas.BFSMatrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    public static BFS bfs;

    public int[][] stage1(){
        bfs = new BFS();
        int[][] matrix = new int[7][7];
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 1;
        matrix[2][5] = 1;
        matrix[2][6] = 1;
        matrix[4][5] = 1;
        return matrix;
    }

    public int[][] stage2(){
        bfs = new BFS();
        int[][] matrix = new int[5][5];
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 1;

        return matrix;
    }

    @Test
    public void test1(){
        int[][] matrix = stage1();
        String[] expected = {"0", "1", "2", "3", "4", "5", "6"};
        assertArrayEquals(expected, BFS.BFSMatrixAdjacencyList(matrix, 0));

    }

    @Test
    public void test2(){

        int[][] matrix = stage2();
        String[] expected = {"0", "1", "2", "3", "4"};
        assertEquals("[0, 1, 2, 3, 4]", Arrays.toString(BFS.BFSMatrixAdjacencyList(matrix,0)));

    }

}