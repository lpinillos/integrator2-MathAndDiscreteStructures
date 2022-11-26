package com.example.integradora2discretas.DijkstraMatrix;

import java.util.ArrayList;

public class Heap<T> implements IPriorityQueue<T> {
    private ArrayList<PriorityNode<T>> arr;

    public Heap() {
        arr = new ArrayList<>();
        arr.add(null);
    }

    public void addElement(int value, T element) {
        arr.add(new PriorityNode(value, element));
        buildMinHeapify();
    }


    public void minHeapify(int index) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int smallest;
        if (left < arr.size() && arr.get(left).getValue() < arr.get(index).getValue()) {
            smallest = left;
        } else {
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
    public void insertElement(int priorityValue, T element) {
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
