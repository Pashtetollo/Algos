package test;

import main.KruscalImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KruscalImplTest {

    @Test
    public void kruscalShrinkGraphTest() throws Exception {
        String path = "src/resourses/KruscalTest.in";
        ArrayList<ArrayList<Integer>> shrinked = KruscalImpl.kruscalShrinkGraph(path);
        int totalWeight = shrinked.stream().mapToInt(elem -> elem.get(2)).sum();
        assertEquals(8, totalWeight);
    }
}