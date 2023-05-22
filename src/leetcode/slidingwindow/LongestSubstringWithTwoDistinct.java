package leetcode.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithTwoDistinct {

    public static void main(String args[]) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = 0;
        int maxStr = 0;
        int uc = 0;
        HashMap<Character, Integer> uMap = new HashMap<>();

        while (j < s.length()) {
            char currentChar = s.charAt(j);
            uMap.put(currentChar, uMap.getOrDefault(currentChar, 0) + 1);
            if (uMap.get(currentChar) == 1)
                uc++;

            while (uc > 2) {
                char leftChar = s.charAt(i);
                uMap.put(leftChar, uMap.get(leftChar) - 1);
                if (uMap.get(leftChar) == 0) {
                    uMap.remove(leftChar);
                    uc--;
                }
                i++;
            }

            maxStr = Math.max(maxStr, j - i + 1);
            j++;
        }

        return maxStr;
    }

}
