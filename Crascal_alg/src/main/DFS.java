package main;

import java.util.*;


public class DFS
{
    int V;                                          //number of nodes

    LinkedList<Integer>[] adj;                      //adjacency list

    DFS(int V)
    {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();

    }

    void addEdge(int v, int w)
    {
        adj[w].add(v);
        adj[v].add(w);
    }
    void removeEdge(int v, int w)
    {
        for(int i=0; i<adj[v].size(); i++) {
            if (adj[v].get(i) == w) {
                adj[v].remove(i);
                }
            }
        for(int i=0; i<adj[w].size(); i++){
            if (adj[w].get(i) ==v){
                adj[w].remove(i);
                }
            }
    }

    Boolean isCyclicUtil(int v,
                         Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it =
                adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
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
    Boolean isCyclic()
    {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++)
        {

            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }

        return false;
    }
}
