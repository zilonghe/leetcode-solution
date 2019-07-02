package 数组和字符串.二进制求和67;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
class Solution {
    public String addBinary(String a, String b) {
        char[] ret = ("0" + (a.length() > b.length() ? a : b)).toCharArray();
        int carry = 0;
        for (int i = 0; i < ret.length; i++) {
            int indexa = a.length() - 1 - i;
            int indexb = b.length() - 1 - i;

            int p = indexa >= 0 ? a.charAt(indexa) - '0' : 0;
            int q = indexb >= 0 ? b.charAt(indexb) - '0' : 0;
            int indexret = ret.length - 1 - i;
            char tmp = (char) (p + q + carry);
            carry = tmp / 2;
            ret[indexret] = (char) ((tmp % 2) + '0');
        }
        int beginIndex = 0;
        while (beginIndex < ret.length - 1 && ret[beginIndex] == '0') {
            beginIndex++;
        }
        return new String(ret, beginIndex, ret.length - beginIndex);
    }
}
