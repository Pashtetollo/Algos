package main;

import java.util.*;


public class DFS {
    private final int totalVertexes;

    LinkedList<Integer>[] adjacent;

    DFS(int totalVertexes) {
        this.totalVertexes = totalVertexes;
        adjacent = new LinkedList[totalVertexes];

        for (int i = 0; i < adjacent.length; i++)
            adjacent[i] = new LinkedList<Integer>();

    }

    public void addEdge(int vertex1, int vertex2) {
        adjacent[vertex2].add(vertex1);
        adjacent[vertex1].add(vertex2);
    }

    public void removeEdge(int vertex1, int vertex2) {
        for (int i = 0; i < adjacent[vertex1].size(); i++) {
            if (adjacent[vertex1].get(i) == vertex2) {
                adjacent[vertex1].remove(i);
            }
        }
        for (int i = 0; i < adjacent[vertex2].size(); i++) {
            if (adjacent[vertex2].get(i) == vertex1) {
                adjacent[vertex2].remove(i);
            }
        }
    }

    private boolean isNotVisited(Boolean[] visitedArray, Integer elementId) {
        return !visitedArray[elementId];
    }

    private Boolean hasCycleUtil(int vertex,
                                 Boolean[] isVisitedArr, int parent) {
        // Mark the current node as visited
        isVisitedArr[vertex] = true;
        Integer currentAdjacent;

        // Recur for all the vertices
        // adjacent to this vertex
        for (Integer adjacentVertex : adjacent[vertex]) {
            currentAdjacent = adjacentVertex;

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (isNotVisited(isVisitedArr, currentAdjacent)) {
                if (hasCycleUtil(currentAdjacent, isVisitedArr, vertex)) {
                    return true;
                }
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (currentAdjacent != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph
    // contains a cycle, else false.
    public Boolean hasCycle() {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean[] isVisitedArr = new Boolean[totalVertexes];
        for (int i = 0; i < totalVertexes; i++) {
            isVisitedArr[i] = false;
        }

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int currentVertex = 0; currentVertex < totalVertexes; currentVertex++) {

            // Don't recur for currentVertex if already visited
            if (isNotVisited(isVisitedArr, currentVertex) && hasCycleUtil(currentVertex, isVisitedArr, -1)) {
                return true;
            }
        }

        return false;
    }
}
