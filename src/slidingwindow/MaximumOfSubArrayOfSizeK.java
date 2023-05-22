package slidingwindow;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Given array of size n, find maximum in sub arrays of size k
 * n = 8
 * arr[] = 2 3 -1 -3 5 3 6 7
 * k=3
 * ans = 3 3 5 5 6 7
 */

public class MaximumOfSubArrayOfSizeK {

    private static void findMaximumOfSubArray(int[] arr, int n, int k) {

        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            //Before pushing any element remove smaller elements from last
            while (!queue.isEmpty() && queue.peekLast() < arr[j]) {
                queue.pollLast();
            }
            //adding element to the last
            queue.add(arr[j]);
            if (j - i + 1 == k) {
                System.out.printf("%d ", queue.peek());
                //if element at beginning of queue is same as of window start, remove it
                if (arr[i] == queue.peek()) {
                    queue.poll();
                }
                //shifting window size
                i++;
            }
            //shifting window size
            j++;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        findMaximumOfSubArray(arr, n, k);

    }

}
