public class Main {
    static int[] sortZigZag(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        try {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    int temp = arr[i];
                    if (i % 2 == 0) {
                        arr[i] = arr[0];
                        arr[0] = temp;
                    } else {
                        arr[i] = arr[arr.length - 1];
                        arr[arr.length - 1] = temp;
                    }
                    sortZigZag(arr);
                }
            }
            return arr;
        } catch (StackOverflowError e) {
            System.out.println("This array is either too big or impossible to sort by zig-zag rule.\nThis is the best division of duplicate items that could be achieved:");
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 6, 6, 6, 6, 3};
        sortZigZag(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
