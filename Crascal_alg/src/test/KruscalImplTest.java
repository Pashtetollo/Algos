package test;

import main.FileLineReader;
import main.KruscalImpl;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KruscalImplTest {

    @Test
    public void kruscalShrinkGraphTest1() throws Exception {
        String path = "src/resourses/KruscalTest.in";
        ArrayList<ArrayList<Integer>> shrinked = KruscalImpl.kruscalShrinkGraph(path);
        int totalWeight = shrinked.stream().mapToInt(elem -> elem.get(2)).sum();
        assertEquals(8, totalWeight);
    }

    @Test
    public void kruscalShrinkGraphTest2()throws Exception{
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
            writer.write(vertex1+ " ");
            writer.write(vertex2+ " ");
            writer.write(weight);
            writer.write("\n");
        }
        writer.write("\n" + "Total weight of graph: " + totalWeight);
        assertEquals(23, totalWeight);
        writer.close();
    }

}