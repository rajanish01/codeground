package slidingwindow;

import java.util.Scanner;

/**
 * Given array of size N, and sub array of size k, find maximum sum in given sub array
 * n = 7
 * arr[] = 2 5 1 8 2 9 1
 * k = 3
 *
 * ans = 19
 */

public class MaximumSubArrayOfSizeK {

    private static int printMaxInSubArrayOfSizeK(int[] arr, int k) {

        int i = 0, j = 0;
        int sum = 0, maxSum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= arr[i++];
            }
            j++;
        }
        return Math.max(sum, maxSum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(printMaxInSubArrayOfSizeK(arr, k));
    }

}
