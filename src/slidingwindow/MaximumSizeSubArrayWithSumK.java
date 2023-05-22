package slidingwindow;

import java.util.Scanner;

/**
 * Give a positive array of size n, find maximum sub array whose sum is equal to k
 * n = 7
 * arr[] = 4 1 1 1 2 3 5
 * k = 5
 * ans = 4
 */
public class MaximumSizeSubArrayWithSumK {

    private static int findMaximumSubArraySizeWithSumK(int[] arr, int n, int k) {

        int i = 0, j = 0;
        int max = 0;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
            //if sum is equal to k, take amx of index diff and max
            if (sum == k) {
                max = Math.max(max, j - i + 1);
            }
            //If sum > k, subtract elements from start unless sum < k
            else if (sum > k) {
                while (sum > k)
                    sum -= arr[i++];
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(findMaximumSubArraySizeWithSumK(arr, n, k));
    }

}
