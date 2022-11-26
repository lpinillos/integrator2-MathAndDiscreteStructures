package com.example.integradora2discretas.DFSList;

public class Main {
    public static void main(String[] args) {
        DFSAdjacencyList<String> dfs = new DFSAdjacencyList<>();
        // Aquí se insertan los nodos que se van a utilizar. Primero se les pone la posición (identificador) y luego el nombre que se le quire dar al nodo.
        // Estos nodos no están conectados entre sí, entonces si hace la prueba con el método BFS, no va a encontrar ningún camino si no se ha insertado
        // previamente una arista.
        dfs.insertNode(0, "x");
        dfs.insertNode(1, "y");
        dfs.insertNode(2, "z");
        dfs.insertNode(3, "u");
        dfs.insertNode(4, "v");
        dfs.insertNode(5, "w");

        // Aquí se insertan las aristas que se van a utilizar. Primero se le pone la posición del nodo de origen y luego la posición del nodo de destino.
        dfs.insertEdge(3,0);
        dfs.insertEdge(0,1);
        dfs.insertEdge(1,2);
        dfs.insertEdge(2,1);
        dfs.insertEdge(1,4);
        dfs.insertEdge(4,3);

        //En este caso va a dar que el grafo es altamente conexo, pero si se comenta la línea 19 va a dar que no es altamente conexo porque
        // no va a haber ninguna forma para llegar al nodo 2, o sea z.
        // De la misma forma no va a haber forma de llegar al nodo 5, o sea w, si se des comenta la línea 14.


        // Aquí se prueba si el grafo es altamente conexo o no.
        // Se revisa la conexión de cada nodo con todos los demás nodos y si el array de string que se recibe contiene un null
        // es porque no es altamente conexo.
        dfs.DFS(0);


    }
}
