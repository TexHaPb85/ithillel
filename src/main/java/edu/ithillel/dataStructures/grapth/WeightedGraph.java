package edu.ithillel.dataStructures.grapth;

import java.util.*;

public class WeightedGraph<T> {
    private Map<T, Map<T, Integer>> adjacencyMap;

    public WeightedGraph() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyMap.containsKey(vertex)) {
            adjacencyMap.put(vertex, new HashMap<>());
        }
    }

    public void addEdge(T source, T destination, int weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyMap.get(source).put(destination, weight);
        //adjacencyMap.get(destination).put(source, weight);
    }

    public Set<T> getVertices() {
        return adjacencyMap.keySet();
    }

    public Map<T, Integer> getNeighbors(T vertex) {
        return adjacencyMap.getOrDefault(vertex, Collections.emptyMap());
    }

    public int getSize() {
        return adjacencyMap.size();
    }

    public void printGraph() {
        for (Map.Entry<T, Map<T, Integer>> entry : adjacencyMap.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Map.Entry<T, Integer> neighbor : entry.getValue().entrySet()) {
                System.out.print(neighbor.getKey() + "(" + neighbor.getValue() + "km) ");
            }
            System.out.println();
        }
    }

    public int findCheapestPath(T source, T destination) {
        Set<T> visited = new HashSet<>();
        Map<T, Integer> distances = new HashMap<>();
        PriorityQueue<Node<T>> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        // Initialize distances
        for (T vertex : adjacencyMap.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new Node<>(source, 0));

        while (!pq.isEmpty()) {
            Node<T> current = pq.poll();
            T currentVertex = current.vertex;
            int currentDistance = current.distance;

            if (currentVertex.equals(destination)) {
                return distances.get(destination);
            }

            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);

            for (Map.Entry<T, Integer> neighbor : adjacencyMap.get(currentVertex).entrySet()) {
                T neighborVertex = neighbor.getKey();
                int weight = neighbor.getValue();

                int newDistance = currentDistance + weight;
                if (newDistance < distances.get(neighborVertex)) {
                    distances.put(neighborVertex, newDistance);
                    pq.offer(new Node<>(neighborVertex, newDistance));
                }
            }
        }
        return -1;
    }

    private static class Node<T> {
        T vertex;
        int distance;

        public Node(T vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Depth-First Traversal (DFS) using Stack
    public Set<T> dfs(T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);

                for (T neighbor : adjacencyMap.getOrDefault(currentVertex, Collections.emptyMap()).keySet()) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return visited;
    }

    // Breadth-First Traversal (BFS) using Queue
    public Set<T> bfs(T startVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            T currentVertex = queue.poll();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);

                for (T neighbor : adjacencyMap.getOrDefault(currentVertex, Collections.emptyMap()).keySet()) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return  visited;
    }


    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Adding Ukrainian cities and towns
        graph.addEdge("Kyiv", "Kharkiv", 477);
        graph.addEdge("Kyiv", "Lviv", 545);
        graph.addEdge("Kyiv", "Odessa", 475);
        graph.addEdge("Kyiv", "Dnipro", 479);
        graph.addEdge("Kyiv", "Zaporizhzhia", 536);
        graph.addEdge("Kyiv", "Vinnytsia", 267);
        graph.addEdge("Kyiv", "Zhytomyr", 131);
        graph.addEdge("Kyiv", "Chernihiv", 147);
        graph.addEdge("Kharkiv", "Lviv", 901);
        graph.addEdge("Kharkiv", "Odessa", 738);
        graph.addEdge("Lviv", "Odessa", 863);
        graph.addEdge("Odessa", "Kharkiv", 863);
        graph.addEdge("Dnipro", "Zaporizhzhia", 81);
        graph.addEdge("Zaporizhzhia", "Vinnytsia", 487);
        graph.addEdge("Vinnytsia", "Zhytomyr", 107);
        graph.addEdge("Zhytomyr", "Chernihiv", 141);
        graph.addEdge("Chernihiv", "Kharkiv", 343);
        graph.addEdge("Kharkiv", "Sumy", 350);
        graph.addEdge("Kharkiv", "Rivne", 330);
        graph.addEdge("Kharkiv", "Ivano-Frankivsk", 543);
        graph.addEdge("Kharkiv", "Cherkasy", 196);
        graph.addEdge("Kharkiv", "Ternopil", 428);
        graph.addEdge("Kharkiv", "Kropyvnytskyi", 272);
        graph.addEdge("Kharkiv", "Uzhgorod", 867);
        graph.addEdge("Kharkiv", "Khmelnytskyi", 333);
        graph.addEdge("Kharkiv", "Chernivtsi", 507);

        System.out.println("Vertices: " + graph.getVertices());
        System.out.println("Neighbors of Київ: " + graph.getNeighbors("Київ"));
        System.out.println("Graph size: " + graph.getSize());
        System.out.println("Graph:");

        graph.printGraph();

        System.out.println("Cheapest path from Kyiv to Lviv: " + graph.findCheapestPath("Kyiv", "Lviv"));
        System.out.println("Cheapest path from Lviv to Kharkiv: " + graph.findCheapestPath("Lviv", "Kharkiv"));
        System.out.println("Cheapest path from Kharkiv to Odessa: " + graph.findCheapestPath("Kharkiv", "Odessa"));

    }
}