package com.github.hieuvv.da.graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * There are three types of Graph is (Direction, UnDirection), (Weight,Un weight), (Cyclic, Acyclic)
 */
public class GraphDemo {


    public static void main(String[] args) {

        System.out.println("=== Adjacency list implement grap ===");
        demoAdjacencyListGraph();
    }

    static void demoAdjacencyListGraph() {

        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.addVertex(0);
        adjacencyList.addVertex(1);
        adjacencyList.addVertex(2);
        adjacencyList.addVertex(3);
        adjacencyList.addVertex(4);
        adjacencyList.addVertex(5);
        adjacencyList.addVertex(6);

        adjacencyList.addEdge(3, 1);
        adjacencyList.addEdge(3, 4);
        adjacencyList.addEdge(4, 2);
        adjacencyList.addEdge(4, 5);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 0);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(6, 5);

        adjacencyList.showConnections();
    }
}

class AdjacencyEdge {

}

class AdjacencyList {

    private Hashtable<Integer, List<Integer>> adjacencyList;

    private int numberOfNode;

    public AdjacencyList() {
        adjacencyList = new Hashtable<>();
    }

    void addVertex(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
        numberOfNode++;
    }

    void addEdge(Integer node1, Integer node2) {
        // Undirected graph
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    void showConnections() {
        System.out.println("Number of node: " + numberOfNode);
        adjacencyList.forEach((vertex, edges) -> {
            System.out.print(vertex + " :");
            edges.forEach(edge -> System.out.print("\t" + edge));
            System.out.println();
        });
    }
}

class AdjacencyMatrix {

}
