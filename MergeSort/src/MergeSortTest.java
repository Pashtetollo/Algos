import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
public class MergeSortTest{
    @Test
    public void mergeSortAcsArrayAscTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{1,2,3,4,5,6,7,8};
        sorter.mergeSort(ascArray,8, Order.asc);
        assertEquals(0, sorter.getSwapCounter());
        assert(Arrays.equals(ascArray, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
    @Test
    public void mergeSortDescArrAscTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{8,7,6,5,4,3,2,1};
        sorter.mergeSort(ascArray,8, Order.asc);
        assertEquals(12, sorter.getSwapCounter());
        assert(Arrays.equals(ascArray, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
    @Test
    public void mergeSortDescArrDescTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{8,7,6,5,4,3,2,1};
        sorter.mergeSort(ascArray,8, Order.desc);
        assertEquals(0, sorter.getSwapCounter());
        assert(Arrays.equals(ascArray, new int[]{8,7,6,5,4,3,2,1}));
    }
    @Test
    public void mergeSortAcsArrayDescTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{1,2,3,4,5,6,7,8};
        sorter.mergeSort(ascArray,8, Order.desc);
        assertEquals(12, sorter.getSwapCounter());
        assert(Arrays.equals(ascArray, new int[]{8,7,6,5,4,3,2,1}));
    }
    @Test
    public void mergeSortRandomArrAscTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{123,43,12,33,34,64,23,54};
        sorter.mergeSort(ascArray,8, Order.asc);
        assert(Arrays.equals(ascArray, new int[]{12,23,33,34,43,54,64,123}));
    }
    @Test
    public void mergeSortRandomArrDescTest(){
        MergeSort sorter = new MergeSort();
        int[] ascArray = new int[]{123,43,12,33,34,64,23,54};
        sorter.mergeSort(ascArray,8, Order.desc);
        assert(Arrays.equals(ascArray, new int[]{123,64,54,43,34,33,23,12}));
    }
}
