package com.example.integradora2discretas.DijkstraMatrix;

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

public class Dijkstra {

    private String message = "";

    // Make dijkstra algorithm with priority queue and that can print the path between two nodes
    public void dijkstra(Heap<Integer> heap, int[][] matrix, int source, int destination) {
        int[] distance = new int[matrix.length];
        int[] previous = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
        distance[source] = 0;
        heap.insertElement(0, source);
        while (!heap.isEmpty()) {
            int u = heap.extractMin();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[u][i] != 0) {
                    if (distance[i] > distance[u] + matrix[u][i]) {
                        distance[i] = distance[u] + matrix[u][i];
                        previous[i] = u;
                        heap.insertElement(distance[i], i);
                    }
                }
            }
        }

        System.out.println("The shortest path between " + source + " and " + destination + " is: ");
        printPath(previous, destination);
        System.out.println("The distance is: " + distance[destination]);

        message = "The shortest path between " + source + " and " + destination + " is: ";
        message += "The distance is: " + distance[destination];
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Print the path between two nodes
    public static void printPath(int[] previous, int destination) {
        if (previous[destination] != -1) {
            printPath(previous, previous[destination]);
        }
        System.out.print(destination + " ");
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        Dijkstra dijkstra = new Dijkstra();
        int[][] matrix = new int[][]{
                {0, 4, 2, 0, 0, 0},
                {4, 0, 1, 5, 0, 0},
                {2, 1, 0, 8, 10, 0},
                {0, 5, 8, 0, 2, 6},
                {0, 0, 10, 2, 0, 3},
                {0, 0, 0, 6, 3, 0},
        };
        dijkstra.dijkstra(heap, matrix, 3, 0);
    }


}