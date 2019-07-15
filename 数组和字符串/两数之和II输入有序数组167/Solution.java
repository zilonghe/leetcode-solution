package 数组和字符串.两数之和II输入有序数组167;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(nums, 18)));
    }

    /**
     * O(n2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            ret[0] = i + 1;
            int t = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (t - numbers[j] == 0) {
                    ret[1] = j + 1;
                    return ret;
                }
            }
        }
        return ret;
    }

    /**
     * O(n)解法，利用已经是有序输入的特性，双指针法，一个指向头，一个指向尾，头尾和与target比较，如果大于target，
     * 则尾向前移，否则头向后移动，直到相等。
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] ret = new int[2];
        int p = 0;
        int q = numbers.length - 1;
        while (numbers[p] + numbers[q] != target) {
            if (numbers[p] + numbers[q] > target) {
                q--;
            } else {
                p++;
            }
        }
        ret[0] = p + 1;
        ret[1] = q + 1;
        return ret;
    }
}
