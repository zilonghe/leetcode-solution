package 数组和字符串.长度最小的子数组209;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
class Solution {

    private boolean flag = false;

    public static void main(String[] args) {
        int[] input = {2, 3, 1, 2, 4, 3};
        System.out.println(new Solution().minSubArrayLen(3, input));
    }

    /**
     * 暴力递归法，O(n2)
     */
    public int minSubArrayLen(int s, int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int tmp = func(s, nums, i);
            ret = Math.min(ret, tmp);
        }
        return flag ? ret : 0;
    }

    private int func(int s, int[] nums, int index) {
        if (index >= nums.length) {
            return nums.length;
        }
        int leftOver = s - nums[index];
        if (leftOver <= 0) {
            flag = true;
            return 1;
        }
        return 1 + func(leftOver, nums, ++index);
    }

    /**
     * 双指针发，滑动窗口，O(n)
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int begin = 0;
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ret = Math.min(ret, i - begin + 1);
                sum -= nums[begin++];
            }
        }
        return ret != Integer.MAX_VALUE ? ret : 0;
    }
}