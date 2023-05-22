package slidingwindow;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string s, find maximum sub array with k unique characters
 * s = aabacbebebe
 * k = 3
 * ans = 7
 */

public class MaximumSubstringWithKUniqueCharacters {

    private static int findMaximumSubstringWithKUniqueCharacters(String s, int k) {

        if (k == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int maxLen = 0, len = 0;

        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }
            if (map.size() <= k) {
                len = j - i + 1;
            } else {
                maxLen = Math.max(maxLen, len);
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return Math.max(len, maxLen);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(findMaximumSubstringWithKUniqueCharacters(s, k));

    }

}
