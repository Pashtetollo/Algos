public class Main {
    public static void main(String[] args) {
        String[] temp = args[1].split(",");
        int[] arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
        Order order = Order.valueOf(args[0]);
        long startTime = System.nanoTime();
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr, arr.length, order);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("-------------------------\nMergeSort:\n" +
                "execution time: " + time / 1000000.0 + " ms\n" +
                "Comparisons: " + sorter.comparisonCounter + "\n" +
                "Swaps: " + sorter.swapCounter + "\n" +
                "Order: " + args[0]);
        System.out.println("Ordered array:");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("\n-------------------------");
    }
}

