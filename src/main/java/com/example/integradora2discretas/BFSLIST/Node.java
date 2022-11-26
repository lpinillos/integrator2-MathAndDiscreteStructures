package com.example.integradora2discretas.BFSLIST;

import java.util.ArrayList;

public class Node<V> {

    private V value;
    private int color;
    private Node<V> father;
    private int distance;
    private ArrayList<Node<V>> next;

    public Node(V value) {
        next = new ArrayList<>();
        this.value = value;
    }

    public void addNode(Node<V> node) {
        next.add(node);
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Node<V> getFather() {
        return father;
    }

    public void setFather(Node<V> father) {
        this.father = father;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Node<V>> getNext() {
        return next;
    }

    public void setNext(ArrayList<Node<V>> next) {
        this.next = next;
    }

}
