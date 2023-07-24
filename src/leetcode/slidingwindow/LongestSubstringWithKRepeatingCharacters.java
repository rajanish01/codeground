package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * NOT ACCEPTED
 * The optimal solution to the problem was by using sliding window
 * Refer Editorial for optimal solutions : https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/editorial/
 */
public class LongestSubstringWithKRepeatingCharacters {

    public static int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        int i = 0, j = 0, count = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < n) {
            Character curr = s.charAt(j);
            if (map.get(curr) < k) {
                if (count == tMap.size() && !tMap.isEmpty()) {
                    maxLen = Math.max(maxLen, j - i);
                }
                tMap.clear();
                count = 0;
            } else {
                tMap.put(curr, tMap.getOrDefault(curr, 0) + 1);
                if (tMap.get(curr) == k) {
                    count++;
                }
            }
            j++;
        }
        if (count == tMap.size() && !tMap.isEmpty()) {
            maxLen = Math.max(maxLen, j - i);
        }
        return Math.max(maxLen, 0);
    }

    public static void main(String[] args) {

        String s = "bbaaacbd";
        int k = 3;

        System.out.println(longestSubstring(s, k));

    }

}
