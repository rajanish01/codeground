package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestNiceSubstring {

    public static String longestNiceSubstring(String s) {
        String result = "";
        if (s.length() == 1) return result;
        HashSet<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            set.add(c);
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        int i = 0, j = 0, found = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, false);
            if (map.containsKey((char) (c + ' ')) || map.containsKey((char) (c - ' '))) {
                map.put(c, true);
                found++;
            } else{
                if (!map.isEmpty() && found == map.size() && result.length() < (j - i)) {
                    result = s.substring(i, j - 2);
                }
                map.clear();
                i = j + 1;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s));
    }

}
