package leetcode.slidingwindow;

public class SubstringsOfSize3 {

    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int i = 0, j = 0;
        int count = 0;
        while (j < s.length()) {
            if (j - i + 1 == 3) {
                if (s.charAt(i) != s.charAt(i + 1)
                        && s.charAt(i + 1) != s.charAt(j)
                        && s.charAt(i) != s.charAt(j)) count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }

}
