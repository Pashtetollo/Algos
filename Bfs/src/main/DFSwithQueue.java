package main;

import java.io.IOException;
import java.util.*;


class DFSwithQueue
{
    int V;                                          //number of nodes

    LinkedList<Integer>[] adj;                      //adjacency list

    DFSwithQueue(int V)
    {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();

    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    void DFS(int n) throws Exception {
        boolean nodes[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(n);  //push root node to the stack
        int a = 0;

        while(!stack.empty())
        {
            n = stack.peek();
            stack.pop();

            if(nodes[n] == false)
            {
                System.out.print(n + " ");
                nodes[n] = true;
            }

            for (int i = 0; i < adj[n].size(); i++)
            {
                a = adj[n].get(i);
//                will detect loop but not it's path
//                if (nodes[a]){
//                    throw new Exception("loop detected");
//                }
                if (!nodes[a])      //only push those nodes to the stack which aren't in it already
                {
                    stack.push(a);  //push to the stack
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {

        DFSwithQueue graph = new DFSwithQueue(300);
        ArrayList<ArrayList<Integer>> input = FileLineReader.readFile("src/input.in");
        input.remove(0);
        for (ArrayList<Integer> elem:input) {
            graph.addEdge(elem.get(0),elem.get(1));
        }

        System.out.println("Following is the Depth First Traversal");
        graph.DFS(0);
    }
}