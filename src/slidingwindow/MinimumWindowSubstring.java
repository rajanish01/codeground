package slidingwindow;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {

    private static String findMinimumWindowSubstring(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int x = 0; x < t.length(); x++) {
            if (!tMap.containsKey(t.charAt(x))) {
                tMap.put(t.charAt(x), 1);
            } else {
                tMap.put(t.charAt(x), tMap.get(t.charAt(x)) + 1);
            }
        }

        int i = 0, j = 0;
        String res = s.concat("a");
        String minRes = res;
        int uc = tMap.size();

        while (j < s.length()) {
            if (tMap.containsKey(s.charAt(j))) {
                tMap.put(s.charAt(j), tMap.get(s.charAt(j)) - 1);
                if (tMap.get(s.charAt(j)) == 0) {
                    uc--;
                }
                while (uc == 0) {
                    res = s.substring(i, j + 1);
                    if (tMap.containsKey(s.charAt(i))) {
                        tMap.put(s.charAt(i), tMap.get(s.charAt(i)) + 1);
                        if (tMap.get(s.charAt(i)) > 0) {
                            uc = 1;
                        }
                    }
                    i++;
                }
                minRes = res.length() < minRes.length() ? res : minRes;
            }
            j++;
        }
        return minRes.length() > s.length() ? "" : minRes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(findMinimumWindowSubstring(s, t));
    }

}
