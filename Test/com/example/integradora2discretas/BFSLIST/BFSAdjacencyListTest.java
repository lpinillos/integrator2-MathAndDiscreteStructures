package com.example.integradora2discretas.BFSLIST;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BFSAdjacencyListTest {

    public static BFSAdjacencyList<Integer> bfs;

    public void stage1(){
        bfs = new BFSAdjacencyList<>();

        bfs.insertNode(1,10);
        bfs.insertNode(2,4);
        bfs.insertNode(3,8);
        bfs.insertNode(4,3);
        bfs.insertNode(5,1);
        bfs.insertNode(6,2);

        bfs.insertEdge(1,2);
        bfs.insertEdge(2,3);
        bfs.insertEdge(2,4);
        bfs.insertEdge(3,4);
        bfs.insertEdge(3,5);
        bfs.insertEdge(4,6);
    }

    public void stage2(){
        bfs = new BFSAdjacencyList<>();

        bfs.insertNode(1,10);
        bfs.insertNode(2,4);
        bfs.insertNode(3,8);
        bfs.insertNode(4,3);
        bfs.insertNode(5,1);
        bfs.insertNode(6,2);
        bfs.insertNode(10,10);
        bfs.insertNode(12,4);
        bfs.insertNode(30,8);
        bfs.insertNode(0,3);
        bfs.insertNode(21,1);
        bfs.insertNode(3,2);

        bfs.insertEdge(1,2);
        bfs.insertEdge(2,3);
        bfs.insertEdge(2,4);
        bfs.insertEdge(3,4);
        bfs.insertEdge(3,5);
        bfs.insertEdge(4,6);
        bfs.insertEdge(10,2);
        bfs.insertEdge(2,30);
        bfs.insertEdge(2,21);
        bfs.insertEdge(21,4);
        bfs.insertEdge(0,5);
        bfs.insertEdge(5,0);
    }

    @Test
    public void test1NoneExistingNode(){
        stage1();

        assertNull(bfs.BFS(80));

    }

    @Test
    public void test2VerifyConection(){
        stage1();

        assertEquals("[10, 4, 8, 3, 1, 2]", Arrays.toString(bfs.BFS(1)));

    }

    @Test
    public void test3(){
        stage2();

        assertNull(bfs.BFS(85));
        assertEquals("[8, null, null, null, null, null, null, null, null, null, null]",Arrays.toString(bfs.BFS(30)));
    }



}