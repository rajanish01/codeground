package leetcode.slidingwindow;

/**
 * ACCEPTED, BUT NOT OPTIMAL
 * The optimal solution to the problem was by using binary search (nlogn) and bucket sort (n)
 * Refer Editorial for optimal solutions : https://leetcode.com/problems/contains-duplicate-iii/editorial/
 */
public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i <= nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length && j - i <= indexDiff) {
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 6, 5};
        int indexDiff = 3;
        int valueDiff = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

}
