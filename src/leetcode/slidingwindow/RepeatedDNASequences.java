package leetcode.slidingwindow;

import java.util.*;

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> uSet = new HashSet<>();
        if (s.length() < 10) {
            return new ArrayList<>(result);
        }

        int i = 0, j = 0;

        while (j < s.length()) {
            if (j - i + 1 == 10) {
                String t = s.substring(i, j + 1);
                if (!uSet.contains(t)) {
                    uSet.add(t);
                } else {
                    result.add(t);
                }
                i++;
            }
            j++;
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(findRepeatedDnaSequences(s));
    }

}
