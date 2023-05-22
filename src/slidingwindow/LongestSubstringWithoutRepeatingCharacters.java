package slidingwindow;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string s, find maximum sub string with all unique characters in it.
 * s = abcddefggghijklm
 * ans = 6
 */

public class LongestSubstringWithoutRepeatingCharacters {

    private static int findLongestSubstringWithoutRepeatingCharacters(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0, len = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
                len = j - i + 1;
            } else {
                maxLen = Math.max(len, maxLen);
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                while (map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0){
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
        System.out.println(findLongestSubstringWithoutRepeatingCharacters(s));
    }

}
