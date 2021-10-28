package test;

import main.Kruscal_Impl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Kruscal_ImplTest {

    @Test
    public void kruscalShrinkGraphTest() throws Exception {
        String path = "src/resourses/KruscalTest.in";
        ArrayList<ArrayList<Integer>> shrinked = Kruscal_Impl.kruscalShrinkGraph(path);
        int totalWeight = shrinked.stream().mapToInt(elem -> elem.get(2)).sum();
        assertEquals(8, totalWeight);
    }
}