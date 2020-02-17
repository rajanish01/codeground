package HackerRank.WarmUpChallenges;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rajanish
 * date : 18 Feb 2020
 * Status : Subimission Successful
 */
public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        if (c.length == 2) {
            return 1;
        }
        int jumps = 0;
        for (int i = 0; i < c.length; ) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                jumps++;
                i += 2;
                continue;
            }
            if (i + 1 < c.length && c[i + 1] == 0) {
                jumps++;
                i++;
                continue;
            }
            i++;
        }
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        scanner.close();
    }

}
