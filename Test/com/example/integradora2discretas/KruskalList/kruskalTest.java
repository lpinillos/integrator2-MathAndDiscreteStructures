package com.example.integradora2discretas.KruskalList;

import com.example.integradora2discretas.KruskalMatrix.Kruskals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class kruskalTest {

    public static Solution k;

    public void stage1(){
        k = new Solution();
    }

    @Test
    public void test1(){
        stage1();
        Solution.createSet(10);
        assertEquals("a",Solution.find(9));

    }


}