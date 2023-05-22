package slidingwindow;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Given an array with n characters representing toys, find maximum toys a boy can pick given
 * they are consecutive and maximum unique toys collected should be = 2
 * n = 7
 * arr[] = a b a c c a b
 * ans = 4
 */
public class PickToys {

    private static int findMaxPickToys(String[] arr, int n) {

        int i = 0, j = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0, maxLen = 0;
        while (j < n) {
            if (!map.containsKey(arr[j])) {
                map.put(arr[j], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            if (map.size() > 2) {
                maxLen = Math.max(len, maxLen);
                while (map.size() > 2) {
                    map.remove(arr[i++]);
                }
            } else {
                len = j - i + 1;
            }
            j++;
        }
        return Math.max(len, maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] arr = s.split(" ");
        System.out.println(findMaxPickToys(arr, arr.length));
    }

}
