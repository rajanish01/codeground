package recursion;

import java.util.Arrays;

public class SortAnArray {

    private static void insert(int[] arr, int i, int j, int k) {
        if (i == j) {
            arr[i] = k;
            return;
        }
        if (arr[i] >= k) {
            int temp = arr[i];
            arr[i] = k;
            k = temp;
        }
        insert(arr, i + 1, j, k);
    }

    private static void sort(int[] arr, int start, int end) {
        if (end == 0) return;
        sort(arr, start, end - 1);
        insert(arr, start, end, arr[end]);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 9, -1, 0, 5, 7, 1, 6, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
