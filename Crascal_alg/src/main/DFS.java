package main;

import java.util.*;


public class DFS {
    int totalVertexes;                                          //number of nodes

    LinkedList<Integer>[] adjacent;                      //adjacency list

    DFS(int totalVertexes) {
        this.totalVertexes = totalVertexes;
        adjacent = new LinkedList[totalVertexes];

        for (int i = 0; i < adjacent.length; i++)
            adjacent[i] = new LinkedList<Integer>();

    }

    void addEdge(int vertex1, int vertex2) {
        adjacent[vertex2].add(vertex1);
        adjacent[vertex1].add(vertex2);
    }

    void removeEdge(int vertex1, int w) {
        for (int i = 0; i < adjacent[vertex1].size(); i++) {
            if (adjacent[vertex1].get(i) == w) {
                adjacent[vertex1].remove(i);
            }
        }
        for (int i = 0; i < adjacent[w].size(); i++) {
            if (adjacent[w].get(i) == vertex1) {
                adjacent[w].remove(i);
            }
        }
    }

    Boolean isCyclicUtil(int vertex,
                         Boolean visited[], int parent) {
        // Mark the current node as visited
        visited[vertex] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it =
                adjacent[vertex].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, vertex))
                    return true;
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph
    // contains a cycle, else false.
    Boolean isCyclic() {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[totalVertexes];
        for (int i = 0; i < totalVertexes; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int currentVertex = 0; currentVertex < totalVertexes; currentVertex++) {

            // Don't recur for currentVertex if already visited
            if (!visited[currentVertex])
                if (isCyclicUtil(currentVertex, visited, -1))
                    return true;
        }

        return false;
    }
}
