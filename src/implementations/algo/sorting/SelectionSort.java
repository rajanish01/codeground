package implementations.algo.sorting;

import java.util.Arrays;

public class SelectionSort {
    private static void selectionSort(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {//iterate for every element in array
            int minIndex = i;   //Min index variable initialize
            for (int j = i + 1; j < n; j++) {//Find minimum in remaining array
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];    //Swap ith index and min index
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 11, 2, 0, 9, 6, 5, 1, 6};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
