package test;

import main.Crascal_Impl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Crascal_ImplTest {

    @Test
    public void crascalShrinkGraphTest() throws Exception {
        String path = "src/resourses/crascalTest.in";
        ArrayList<ArrayList<Integer>> shrinked = Crascal_Impl.crascalShrinkGraph(path);
        int totalWeight = shrinked.stream().mapToInt(elem -> elem.get(2)).sum();
        assertEquals(8, totalWeight);
    }
}