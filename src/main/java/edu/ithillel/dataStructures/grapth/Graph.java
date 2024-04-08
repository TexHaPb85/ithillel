package edu.ithillel.dataStructures.grapth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph<T> {
    private Map<T, List<T>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyMap.put(vertex, new ArrayList<>());
    }

    public void addEdge(T source, T destination) {
        if (!adjacencyMap.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyMap.containsKey(destination)) {
            addVertex(destination);
        }
        adjacencyMap.get(source).add(destination);
        adjacencyMap.get(destination).add(source); // for undirected graph
    }

    public List<T> getVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }

    public List<T> getNeighbors(T vertex) {
        return new ArrayList<>(adjacencyMap.get(vertex));
    }

    public int getSize() {
        return adjacencyMap.size();
    }

    public void printGraph() {
        for (Map.Entry<T, List<T>> entry : adjacencyMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (T neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Rob", "Maria");


        System.out.println("Vertices: " + graph.getVertices());
        System.out.println("Neighbors of B: " + graph.getNeighbors("Bob"));
        System.out.println("Graph size: " + graph.getSize());
        System.out.println("Graph:");
        graph.printGraph();
    }
}
