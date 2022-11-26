package com.example.integradora2discretas.KruskalList;
import java.io.*;
import java.util.*;

class kruskal {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, ArrayList<String[]>  Edges) {

        Solution.bubbleSort(Edges);

        int Special_SubTree_Weight = 0;

        Solution.createSet(gNodes);

        for (int i = 0; i < Edges.size(); i++) {

            int u = Integer.parseInt(Edges.get(i)[0]);

            int v = Integer.parseInt(Edges.get(i)[1]);

            if (Solution.find(u) != Solution.find(v)){

                Special_SubTree_Weight += Integer.parseInt(Edges.get(i)[2]);
                Solution.merge(u, v);
            }
        }

        return Special_SubTree_Weight;
    }
}

public class Solution {
    public static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        set = new int[gNodes + 1];

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        ArrayList<String[]>  Edges = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
            Edges.add(gFromToWeight);
        }

        int res = kruskal.kruskals(gNodes, Edges);

        System.out.println(res);

        bufferedReader.close();
    }

    public static void createSet(int gNodes){
        for (int i = 1; i < gNodes + 1; i++) {
            set[i]=i;
        }
    }

    public static int find(int x){
        if(set[x] != x){
            set[x] = find(set[x]);
        }
        return set[x];
    }

    public static void merge(int u, int v){

        int temp = set[u];
        int temp2 = set[v];

        if (u<v){
            for (int i = 0; i < set.length; i++) {
                if (set[i] == temp){
                    set[i] = set[v];
                }
            }
        }else if(v<u){
            for (int i = 0; i < set.length; i++) {
                if (set[i] == temp2){
                    set[i] = set[u];
                }
            }
        }
    }

    public static void bubbleSort(ArrayList<String[]> Edges) {

        for (int j=0; j<Edges.size(); j++) {
            for (int i = 1; i < Edges.size()-j; i++) {

                int weight1 = Integer.parseInt(Edges.get(i)[2]);
                int weight2 = Integer.parseInt(Edges.get(i-1)[2]);

                if (weight1<(weight2)){
                    String[] prev = Edges.get(i - 1);

                    Edges.set(i - 1, Edges.get(i));
                    Edges.set(i, prev);
                }
            }
        }

    }
}
