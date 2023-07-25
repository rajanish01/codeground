package implementations.algo.sorting;

import java.util.Arrays;

public class InsertionSort {
    private static void insertionSort(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {//Iterate over every element in array
            int key = array[i];//Make ith element as key
            int j = i - 1;
            while (j >= 0 && array[j] > key) {//Compare key with previous elements
                array[j + 1] = array[j];  //If previous element is greater than key, shift to right
                j--;
            }
            array[j + 1] = key;//Set key at right place
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 11, 2, 0, 9, 6, 5, 1, 6};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
