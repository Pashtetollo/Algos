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

        ArrayList<ArrayList<Integer>> shrinkedGraph = new ArrayList<>();
        for (ArrayList<Integer> currentVertex : InputArray) {
            graph.addEdge(currentVertex.get(0), currentVertex.get(1));
            shrinkedGraph.add(currentVertex);
            if (graph.hasCycle()) {
                shrinkedGraph.remove(currentVertex);
                graph.removeEdge(currentVertex.get(0), currentVertex.get(1));
            }
        }
        return shrinkedGraph;
    }
}
