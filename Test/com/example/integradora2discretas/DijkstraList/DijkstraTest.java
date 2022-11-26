package com.example.integradora2discretas.DijkstraList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    public static Dijkstra dijkstra;

    public void stage1(){
        dijkstra = new Dijkstra(6);
    }

    @Test
    public void test1VerifyPath(){
        stage1();
        dijkstra.addEdge(1,3,2);
        dijkstra.addEdge(0,1,8);
        dijkstra.addEdge(1,2,1);
        dijkstra.addEdge(0,2,1);
        dijkstra.addEdge(2,3,3);
        dijkstra.addEdge(3,4,4);

        assertEquals("0 8 1 4 8 ",dijkstra.dijkstra(0));

    }

    @Test
    public void test2VerifyPath(){
        stage1();
        dijkstra.addEdge(0, 1, 3);
        dijkstra.addEdge(0, 2, 1);
        dijkstra.addEdge(1, 0, 7);
        dijkstra.addEdge(1, 2, 2);
        dijkstra.addEdge(1, 3, 6);
        dijkstra.addEdge(2, 0, 1);
        dijkstra.addEdge(2, 1, 3);
        dijkstra.addEdge(2, 3, 3);
        dijkstra.addEdge(2, 4, 7);
        dijkstra.addEdge(3, 2, 3);
        dijkstra.addEdge(3, 1, 2);
        dijkstra.addEdge(3, 5, 9);
        dijkstra.addEdge(3, 4, 1);
        dijkstra.addEdge(4, 2, 11);
        dijkstra.addEdge(4, 5, 12);
        dijkstra.addEdge(4, 3, 32);
        dijkstra.addEdge(5, 4, 12);
        dijkstra.addEdge(5, 3, 2);

        assertEquals("12 14 11 14 0 12 ",dijkstra.dijkstra(4));
    }
}