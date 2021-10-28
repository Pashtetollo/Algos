package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Crascal_Impl {
    public static ArrayList<ArrayList<Integer>> crascalShrinkGraph(String path) throws Exception {


        ArrayList<ArrayList<Integer>> inputArr = FileLineReader.readFile(path);
        inputArr.remove(0);
        inputArr.sort(new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
                return arr1.get(2).compareTo(arr2.get(2));
            }
        });

        DFS graph = new DFS(600);
        ArrayList<ArrayList<Integer>> shrinkedGraph = new ArrayList<>();
        for (ArrayList<Integer> elem: inputArr) {
            graph.addEdge(elem.get(0),elem.get(1));
            shrinkedGraph.add(elem);
            if(graph.isCyclic()){
                shrinkedGraph.remove(elem);
                graph.removeEdge(elem.get(0),elem.get(1));
            }
        }
        return shrinkedGraph;
    }
}
