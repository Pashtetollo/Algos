package test;
import main.BoyerMooreImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static main.BoyerMooreImpl.findPatternPos;
import static org.junit.Assert.assertEquals;
public class BoyerMooreTest extends BoyerMooreImpl {
    @Test
    public void findPatternPosTest(){
        ArrayList<Integer> resultPos = new ArrayList<>();
        resultPos.add(7);
        resultPos.add(23);
        char[] pattern ="arrk".toCharArray();
        char[] inputString = "Krasnfjarrkfsaetrrkfsasarrk".toCharArray();
        assertEquals(resultPos, BoyerMooreImpl.findPatternPos(inputString,pattern));
    }
}