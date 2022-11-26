package com.example.integradora2discretas.DijkstraMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    private static Dijkstra dijkstra;
    private static Heap<Integer> heap;

    public void setupStage1() {
        heap = new Heap<>();
        dijkstra = new Dijkstra();

    }

    @Test
    public void test1ForPathVerification() {
        setupStage1();
        int[][] matrix = new int[][]{
                {0, 4, 2, 0, 0, 0},
                {4, 0, 1, 5, 0, 0},
                {2, 1, 0, 8, 10, 0},
                {0, 5, 8, 0, 2, 6},
                {0, 0, 10, 2, 0, 3},
                {0, 0, 0, 6, 3, 0},
        };
        dijkstra.dijkstra(heap, matrix, 3, 0);

        //assertEquals("hola",dijkstra.dijkstraForTest(heap, matrix, 3, 0));

    }

}