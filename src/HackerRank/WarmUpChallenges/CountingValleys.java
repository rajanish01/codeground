package HackerRank.WarmUpChallenges;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rajanish
 * date : 18 Feb 2020
 * Status : Subimission Successful
 */
public class CountingValleys {

    static int countingValleys(int n, String s) {
        int tracker = 0;
        int valleyCount = 0;
        boolean inValley = false;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (sArray[i] == 'D') {
                tracker--;
            } else {
                tracker++;
            }
            if (tracker < 0 && !inValley) {
                inValley = true;
                valleyCount++;
            }
            if (tracker >= 0) {
                inValley = false;
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);
        scanner.close();
    }

}
