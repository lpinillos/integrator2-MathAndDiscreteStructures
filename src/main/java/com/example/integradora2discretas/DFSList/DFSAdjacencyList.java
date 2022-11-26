package com.example.integradora2discretas.DFSList;

import java.util.Hashtable;

public class DFSAdjacencyList<V> {

    public final Hashtable<Integer, Node<V>> node;

    public DFSAdjacencyList() {
        node = new Hashtable<Integer, Node<V>>();
    }

    public void insertNode(int position, V v){
        if(node.isEmpty() || node.get(position) == null){
            Node<V> node1 = new Node<>(v);
            node.put(position, node1);
        } else {
            System.out.println("Node already exists");
        }

    }

    public void insertEdge(int position1, int position2){
        if(node.get(position1) != null && node.get(position2) != null){
            node.get(position1).addNode(node.get(position2));
        } else {
            System.out.println("Node does not exist");
        }

    }

    public void DFS(int position){
        if(node.get(position) != null){
            for (int i = 0; i < node.size(); i++) {
                node.get(i).setColor(0);
                node.get(i).setFather(null);
            }
            DFSVisit(node.get(position));
        } else {
            System.out.println("Node does not exist");
        }
    }

    private void DFSVisit(Node<V> node){
        node.setColor(1);
        for (int i = 0; i < node.getNext().size(); i++) {
            if(node.getNext().get(i).getColor() == 0){
                node.getNext().get(i).setFather(node);
                DFSVisit(node.getNext().get(i));
                System.out.println(node.getNext().get(i).getValue());
            }
        }
        node.setColor(2);
    }

}


