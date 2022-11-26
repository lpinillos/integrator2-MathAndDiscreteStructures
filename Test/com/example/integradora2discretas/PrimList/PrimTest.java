package com.example.integradora2discretas.PrimList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {

    public static Prim prim;
    public static Heap<Integer> heap;
    public static ArrayList<ArrayList<Integer>> adjList;

    public static ArrayList<ArrayList<Integer>> adjW;

    public void stage1(){
        prim = new Prim();
        heap = new Heap<>();
        adjList = new ArrayList<>();
        adjW = new ArrayList<>();
    }

    @Test
    public void test1(){
        stage1();

        assertEquals("a",prim.prim(heap,adjList,adjW,1));

    }

}