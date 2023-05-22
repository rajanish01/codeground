package leetcode.slidingwindow;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                minSize = Math.min(minSize, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int target = 15;

        System.out.println(minSubArrayLen(target, nums));

    }

}
