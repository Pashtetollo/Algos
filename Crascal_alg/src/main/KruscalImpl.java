package main;

import java.util.ArrayList;
import java.util.Comparator;

public class KruscalImpl {
    public static ArrayList<ArrayList<Integer>> kruscalShrinkGraph(String path) throws Exception {


        ArrayList<ArrayList<Integer>> InputArray = FileLineReader.readFile(path);
        InputArray.remove(0);
        InputArray.sort(new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
                return arr1.get(2).compareTo(arr2.get(2));
            }
        });

        DFS graph = new DFS(InputArray.size()+1);

        ArrayList<ArrayList<Integer>> shrunkGraph = new ArrayList<>();
        Integer vertex1, vertex2;
        for (ArrayList<Integer> currentVertex : InputArray) {
            vertex1 = currentVertex.get(0);
            vertex2 = currentVertex.get(1);
            graph.addEdge(vertex1, vertex2);
            shrunkGraph.add(currentVertex);
            if (graph.hasCycle()) {
                shrunkGraph.remove(currentVertex);
                graph.removeEdge(vertex1, vertex2);
            }
        }
        return shrunkGraph;
    }
}
