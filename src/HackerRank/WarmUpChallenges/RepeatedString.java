package HackerRank.WarmUpChallenges;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rajanish
 * date : 18 Feb 2020
 * Status : Subimission Successful
 */
public class RepeatedString {

    static long repeatedString(String s, long n) {
        int aCount = 0;
        long totalCount = 0;
        char[] sArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] == 'a') {
                aCount++;
            }
        }
        totalCount = (n / s.length()) * aCount;
        long rem = n % s.length();
        for (int i = 0; i < rem; i++) {
            if (sArray[i] == 'a') {
                totalCount++;
            }
        }
        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
        scanner.close();
    }

}
