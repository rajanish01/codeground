package slidingwindow;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * Given array of size N, and sub array of size k, find first -ve in given sub array
 * n = 9
 * arr[] = 12 -1 -7 8 -15 30 16 28 -2
 * k = 3
 * <p>
 * ans = -1-1 -7 -15-15 0 -2
 */

public class FirstNegativeInSubArrayOfSizeK {

    private static void printFirstNegativeInSubArrayOfSizeK(int[] arr, int k) {

        int i = 0, j = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 >= k) {
                if (queue.isEmpty()) {
                    System.out.print("0 ");
                } else {
                    if (arr[i] == queue.peek()) {
                        System.out.printf("%d ", queue.poll());
                    } else {
                        System.out.printf("%d ", queue.peek());
                    }
                }
                i++;
            }
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

        printFirstNegativeInSubArrayOfSizeK(arr, k);
    }

}
