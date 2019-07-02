package 数组和字符串.实现strStr28;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaaa", "bba"));
        System.out.println(new Solution().strStr("bba", "bba"));
        System.out.println(new Solution().strStr("bbbba", "bba"));
        System.out.println(new Solution().strStr("", "bba"));
        System.out.println(new Solution().strStr("bba", ""));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int max = source.length - 1 - (target.length - 1);
        char first = target[0];

        for (int i = 0; i <= max; i++) {
            while (source[i] != first && ++i <= max) {

            }
            if (i <= max) {
                int end = i + target.length;
                int j = i + 1, k = 1;
                for (; j < end && source[j] == target[k]; j++, k++) {

                }
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
}
