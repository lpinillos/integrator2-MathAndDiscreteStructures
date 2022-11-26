package com.example.integradora2discretas.BFSLIST;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAdjacencyList<V> {

    public final Hashtable<Integer, Node<V>> node;
    private final Queue<Node<V>> queue;

    public BFSAdjacencyList() {
        node = new Hashtable<Integer, Node<V>>();
        queue = new LinkedList<Node<V>>();
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

    public String[] BFS(int position){
        if(node.get(position) != null){
            String[] result = new String[node.size()];
            int i = 0;
            for (Node<V> n : node.values()) {
                n.setColor(0);
                n.setDistance(0);
                n.setFather(null);
            }
            node.get(position).setColor(1);
            node.get(position).setDistance(0);
            node.get(position).setFather(null);
            queue.add(node.get(position));
            while(!queue.isEmpty()){
                Node<V> u = queue.remove();
                for (Node<V> v : u.getNext()) {
                    if(v.getColor() == 0){
                        v.setColor(1);
                        v.setDistance(u.getDistance() + 1);
                        v.setFather(u);
                        queue.add(v);
                    }
                }
                u.setColor(2);
                result[i] = u.getValue().toString();
                i++;
            }
            return result;
        } else {
            System.out.println("Node does not exist");
            return null;
        }
    }


}


