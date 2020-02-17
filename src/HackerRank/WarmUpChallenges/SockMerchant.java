package HackerRank.WarmUpChallenges;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Rajanish
 * date : 18 Feb 2020
 * Status : Subimission Successful
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        HashSet<Integer> uniqueSocks = new HashSet<>();
        int sockPairs = 0;
        for (int i = 0; i < n; i++) {
            if (uniqueSocks.contains(ar[i])) {
                sockPairs++;
                uniqueSocks.remove(ar[i]);
            } else {
                uniqueSocks.add(ar[i]);
            }
        }
        return sockPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
        scanner.close();
    }

}
