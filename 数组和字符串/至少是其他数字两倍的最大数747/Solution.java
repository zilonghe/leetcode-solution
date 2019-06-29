package 数组和字符串.至少是其他数字两倍的最大数747;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * <p>
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 */
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int min = 0;
        int max = 0;

        if (nums[0] > nums[1]) {
            min = 1;
            max = 0;
        } else {
            min = 0;
            max = 1;
        }
        if (nums.length > 2) {
            for (int i = 2; i < nums.length; i++) {
                int cur = nums[i];
                if (cur > nums[max]) {
                    min = max;
                    max = i;
                } else if (cur <= nums[max] && cur >= nums[min]) {
                    min = i;
                }
            }
        }

        if (nums[max] >= nums[min] * 2) {
            return max;
        } else {
            return -1;
        }
    }
}
