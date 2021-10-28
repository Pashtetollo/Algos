package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "src/resourses/Kruscal.in";
        ArrayList<ArrayList<Integer>> shrunk = KruscalImpl.kruscalShrinkGraph(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/resourses/Kruscal.out"));
        int totalWeight = 0;
        int weight = 0;
        int vertex1, vertex2;
        for (ArrayList<Integer> elem : shrunk) {
            vertex1 = elem.get(0);
            vertex2 = elem.get(1);
            weight = elem.get(2);
            totalWeight += weight;
            writer.write("n1: " + vertex1 + " ");
            writer.write("n2: " + vertex2 + " ");
            writer.write("weight: " + weight + " ");
            writer.write("\n");
        }
        writer.write("\n" + "Total weight of graph: " + totalWeight);
        writer.close();
    }
}
