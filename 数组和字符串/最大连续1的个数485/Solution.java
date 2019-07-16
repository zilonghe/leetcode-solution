package 数组和字符串.最大连续1的个数485;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
class Solution {
    public static void main(String[] args) {
        int[] input = {1, 1, 0, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(input));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ret = Math.max(ret, tmp);
                tmp = 0;
            } else {
                if (nums[i] == 1) {
                    tmp++;
                }
            }
        }
        return Math.max(tmp, ret);
    }
}
