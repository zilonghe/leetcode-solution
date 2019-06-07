package 目标和;


import java.util.stream.IntStream;

//todo: 可以用动态规划解决，现在太慢了
class Solution {

    private int ret = 0;

    public static void main(String[] args) {
        int[] i = {42, 16, 31, 11, 36, 19, 9, 3, 25, 0, 27, 29, 35, 29, 45, 15, 35, 42, 35, 23};
        int target = 39;
        System.out.println(new Solution().findTargetSumWays(i, target));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = IntStream.of(nums).sum();
        func(nums, S, sum, 0);
        return ret;
    }

    private void func(int[] nums, int target, int sum, int nextIndex) {
        if (sum < Math.abs(target)) {
            return;
        }
        if (nextIndex == nums.length) {
            if (target == 0) {
                ret++;
            }
            return;
        }
        int cur = nums[nextIndex];
        sum -= cur;
        func(nums, target + cur, sum, nextIndex + 1);
        func(nums, target - cur, sum, nextIndex + 1);
    }
}



