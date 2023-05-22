package slidingwindow;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string S and pattern P, count occurances of anagrams of P in S
 * <p>
 * S = acbexxjecbabbcaabca
 * P = abc
 * <p>
 * https://youtu.be/MW4lJ8Y0xXk
 */

public class CountAnagramsInAGivenString {

    private static int anagramCounterInString(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();

        //Creating map of all unique characters in the pattern
        for (int x = 0; x < p.length(); x++) {
            if (!map.containsKey(p.charAt(x))) {
                map.put(p.charAt(x), 1);
            } else {
                map.put(p.charAt(x), map.get(p.charAt(x)) + 1);
            }
        }
        //count of unique elements in map
        int count = map.size();
        int ans = 0;

        int i = 0, j = 0;
        while (j < s.length()) {
            //checking from start if character from s exists in map then reduce the map by 1
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                //if map count goes to 0,means that character is exhausted in the window, so unique count reduced by 1
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            //if final unique count becomes 0, it means all elements from map is found in window
            if (count == 0) {
                ans++;
            }
            //shifting window to next character
            if (j - i + 1 == p.length()) {
                //increase map count if character exists in map
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    //updating unique count back to 1, if map count goes back from 0-1
                    if (map.get(s.charAt(i)) == 1)
                        count++;
                }
                //sliding window from left by 1
                i++;
            }
            //sliding window from right by 1
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String P = sc.nextLine();

        System.out.println(anagramCounterInString(S, P));

    }
}
