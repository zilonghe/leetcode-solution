package 数组和字符串.数组拆分I561;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int ret = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            ret += nums[i];
        }
        return ret;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin > end) {
            return;
        }
        int i = begin;
        int j = end;
        int init = nums[begin];
        while (i < j) {
            while (nums[j] >= init && i < j) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (nums[i] <= init && i < j) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = init;
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }
}
