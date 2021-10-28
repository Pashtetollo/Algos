package test;

import main.KruscalImpl;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class KruscalImplTest {

    @Test
    public void kruscalShrinkGraphTest1() throws Exception {
        String path = "src/resourses/KruscalTest.in";
        ArrayList<ArrayList<Integer>> shrunkGraph = KruscalImpl.kruscalShrinkGraph(path);
        int totalWeight = shrunkGraph.stream().mapToInt(elem -> elem.get(2)).sum();
        assertEquals(8, totalWeight);
    }

    @Test
    public void kruscalShrinkGraphTest2()throws Exception{
        String path = "src/resourses/Kruscal.in";
        ArrayList<ArrayList<Integer>> shrunkGraph = KruscalImpl.kruscalShrinkGraph(path);
        int totalWeight = 0;
        int weight = 0;
        int vertex1;
        Integer vertex2;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/resourses/Kruscal.out"))){for (ArrayList<Integer> elem : shrunkGraph) {
            vertex1 = elem.get(0);
            vertex2 = elem.get(1);
            weight = elem.get(2);
            totalWeight += weight;
            writer.write("vertex1: " +vertex1+ " ");
            writer.write("vertex2: "+vertex2+ " ");
            writer.write("weight: " +weight +" ");
            writer.write("\n");
        }
            writer.write("\n" + "Total weight of graph: " + totalWeight);
            assertEquals(23, totalWeight);
        } catch (IOException e){
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "could not open file for writing", e);
        }

    }

}