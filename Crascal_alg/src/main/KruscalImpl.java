package main;

import java.io.IOException;
import java.util.ArrayList;

public class KruscalImpl {
    private KruscalImpl(){}
    public static ArrayList<ArrayList<Integer>> kruscalShrinkGraph(String path) throws IOException {


        ArrayList<ArrayList<Integer>> inputArray = FileLineReader.readFile(path);
        inputArray.remove(0);
        inputArray.sort((arr1, arr2) -> arr1.get(2).compareTo(arr2.get(2)));

        DFS graph = new DFS(inputArray.size()+1);

        ArrayList<ArrayList<Integer>> shrunkGraph = new ArrayList<>();
        Integer vertex1;
        Integer vertex2;
        for (ArrayList<Integer> currentVertex : inputArray) {
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
