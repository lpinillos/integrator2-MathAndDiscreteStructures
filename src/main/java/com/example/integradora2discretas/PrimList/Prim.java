package com.example.integradora2discretas.PrimList;

import java.util.ArrayList;
import java.util.Scanner;

class PriorityNode<T> {
    private int value;
    private T element;

    public PriorityNode(int priorityValue, T element) {
        this.value = priorityValue;
        this.element = element;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

interface IPriorityQueue<T> {
    void insertElement(int priorityValue, int element);
    T extractMin();
    void decreaseKey(int element, int newPriorityValue);
    String showElements();
    T showMaximum();
    public boolean isEmpty();
}

class Heap<T> implements IPriorityQueue<T> {
    private ArrayList<PriorityNode<T>> arr;

    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }

    public void addElement(int value, int element) {
        arr.add(new PriorityNode(value, element));
        buildMinHeapify();
    }


    public void minHeapify(int index) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int smallest;
        if (left < arr.size() && arr.get(left).getValue() < arr.get(index).getValue()) {
            smallest = left;
        }else {
            smallest = index;
        }
        if (right < arr.size() && arr.get(right).getValue() < arr.get(smallest).getValue()) {
            smallest = right;
        }
        if (smallest != index) {
            PriorityNode<T> aux = arr.get(index);
            arr.set(index, arr.get(smallest));
            arr.set(smallest, aux);
            minHeapify(smallest);
        }
    }

    public void buildMinHeapify() {
        for (int i = arr.size() / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public ArrayList<T> heapSort() {
        Heap<T> heap = new Heap<>();
        heap.setArr((ArrayList<PriorityNode<T>>) this.arr.clone());
        ArrayList<T> arrayList = new ArrayList<>();
        while (true) {
            T element = heap.extractMin();
            if (element == null) break;
            arrayList.add(element);
        }
        return arrayList;
    }

    public String print() {
        String ans = "";
        for (int i = 1; i < arr.size(); i++) {
            ans += arr.get(i).getValue() + " ";
        }
        return ans;
    }

    public ArrayList<PriorityNode<T>> getArr() {
        return arr;
    }

    public void setArr(ArrayList<PriorityNode<T>> arr) {
        this.arr = arr;
    }

    @Override
    public boolean isEmpty() {
        if (arr.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void insertElement(int priorityValue, int element) {
        addElement(priorityValue, element);
    }

    @Override
    public T extractMin() {
        if (isEmpty()) {
            return null;
        }
        PriorityNode<T> min = arr.get(1);
        arr.set(1, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        minHeapify(1);
        return min.getElement();
    }


    @Override
    public void decreaseKey(int element, int newPriorityValue) {
        int index = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).getElement().equals(element)) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            return;
        }
        arr.get(index).setValue(newPriorityValue);
        while (index > 1 && arr.get(index / 2).getValue() > arr.get(index).getValue()) {
            PriorityNode<T> aux = arr.get(index);
            arr.set(index, arr.get(index / 2));
            arr.set(index / 2, aux);
            index = index / 2;
        }
    }

    @Override
    public String showElements() {
        String ans = "";
        for (int i = 1; i < arr.size(); i++) {
            ans += arr.get(i).getValue() + " " + arr.get(i).getElement().toString() + "\n";
        }
        return ans;
    }

    @Override
    public T showMaximum() {
        return arr.get(1).getElement();
    }

    public T getElementA(int index) {
        return arr.get(index).getElement();
    }
}


public class Prim {

    // Make prim with adjancency list and priority queue

    public static String prim(Heap<Integer> heap, ArrayList<ArrayList<Integer>> adjList, ArrayList<ArrayList<Integer>> adjListWeight, int start) {
        String msg = "";
        int[] parent = new int[adjList.size()];
        int[] key = new int[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            key[i] = Integer.MAX_VALUE;
        }
        key[start] = 0;
        heap.insertElement(0, start);
        while (!heap.isEmpty()) {
            int u = heap.extractMin();
            for (int i = 0; i < adjList.get(u).size(); i++) {
                int v = adjList.get(u).get(i);
                int weight = adjListWeight.get(u).get(i);
                if (heap.getElementA(v) != null && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    heap.decreaseKey(v, weight);
                }
            }
        }
        for (int i = 0; i < adjList.size(); i++) {
            msg += parent[i] + " " + i;
        }

        return msg;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjListWeight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjListWeight.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            adjListWeight.get(u).add(weight);
            adjListWeight.get(v).add(weight);
        }
        Heap<Integer> heap = new Heap<>();
        prim(heap, adjList, adjListWeight, 0);
    }

}
