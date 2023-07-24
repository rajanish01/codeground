package implementations.algo.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {             //Iterating for every element in the array
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {   //Iterating for elements again for each iteration
                if (array[j] > array[j + 1]) {      //Checking if adjacent elements are sorted, else swap them
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{3, 7, 11, 2, 0, 9, 6, 5, 1, 6};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

}
