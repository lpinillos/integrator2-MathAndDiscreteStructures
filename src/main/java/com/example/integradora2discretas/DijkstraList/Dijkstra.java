package com.example.integradora2discretas.DijkstraList;

import java.util.ArrayList;

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
    void insertElement(int priorityValue, T element);
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

public class Dijkstra {
    private int V;
    private int E;
    private int[][] adj;
    private int[] dist;
    private int[] prev;
    private boolean[] visited;
    private Heap<Integer> q;

    public Dijkstra(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
        this.dist = new int[V];
        this.prev = new int[V];
        this.visited = new boolean[V];
        this.q = new Heap<Integer>();
    }

    public void addEdge(int u, int v, int w) {
        adj[u][v] = w;
        E++;
    }

    public String dijkstra(int s) {
        String msg = "";
        dist[s] = 0;
        for (int i = 0; i < V; i++) {
            if (i != s) {
                dist[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
            q.insertElement(dist[i], i);
        }
        while (!q.isEmpty()) {
            int u = q.extractMin();
            //visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (adj[u][v] != 0) {
                    if (dist[v] > dist[u] + adj[u][v]) {
                        dist[v] = dist[u] + adj[u][v];
                        prev[v] = u;
                        q.decreaseKey(v, dist[v]);
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                msg += dist[i] + " ";
            }
        }

        return msg;

    }

    public void printPath(int s, int v) {
        if (v == s) {
            System.out.print(s);
        } else if (prev[v] == -1) {
            System.out.print("No path from " + s + " to " + v + " exists.");
        } else {
            printPath(s, prev[v]);
            System.out.print(" -> " + v);
        }
    }

    public void printDist(int s) {
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + s + " to " + i + ": " + dist[i]);
        }
    }




    public static void main(String[] args) {
        Dijkstra g = new Dijkstra(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 0, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 0, 2);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 4, 10);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 1, 5);
        g.addEdge(3, 2, 8);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 5, 6);
        g.addEdge(4, 2, 10);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, 3);
        g.addEdge(5, 3, 6);
        g.addEdge(5, 4, 3);

        g.addEdge(3, 0, 3);

        g.dijkstra(3);
        g.printDist(5);
        g.printPath(0,5  );

    }

}
