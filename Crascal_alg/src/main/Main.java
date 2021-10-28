package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> shrinked = Crascal_Impl.crascalShrinkGraph();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/resourses/Crascal.out"));
        int totalWeight = 0;
        int weight =0;
        int node1, node2;
        for(ArrayList<Integer> elem:shrinked){
            node1=elem.get(0);
            node2=elem.get(1);
            weight= elem.get(2);
            totalWeight+=weight;
            writer.write("n1: " +node1 +" ");
            writer.write("n2: " +node2 +" ");
            writer.write("weight: " +weight +" ");
            writer.write("\n");
        }
        writer.write("\n" + "Total weight of graph: "+ totalWeight);
        writer.close();
    }
}
