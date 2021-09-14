public class MergeSort {
     int comparisonCounter = 0;

    public  int getComparisonCounter() {
        return comparisonCounter;
    }

    public  int getSwapCounter() {
        return swapCounter;
    }

    int swapCounter = 0;

    public  void clearCounter() {
        comparisonCounter = 0;
        swapCounter = 0;
    }

    protected void merge(int[] arr, int[] l, int[] r, int left, int right, Order order) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            comparisonCounter++;
            if (order == Order.asc) {
                if (l[i] <= r[j]) {
                    if (arr[k] != l[i]) {
                        swapCounter++;
                    }
                    arr[k++] = l[i++];
                } else {
                    if (arr[k] != r[j]) {
                        swapCounter++;
                    }
                    arr[k++] = r[j++];
                }
            } else {
                if (l[i] >= r[j]) {
                    if (arr[k] != l[i]) {
                        swapCounter++;
                    }
                    arr[k++] = l[i++];
                } else {
                    if (arr[k] != r[j]) {
                        swapCounter++;
                    }
                    arr[k++] = r[j++];
                }
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    public void mergeSort(int[] arr, int len, Order order) {
        comparisonCounter++;
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < len; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left, mid, order);
        mergeSort(right, len - mid, order);
        merge(arr, left, right, mid, len - mid, order);
    }
}
