package 数组和字符串.加一66;

/**
 *
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) digits[i] += 1;
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry != 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = carry;
            for (int i = 1; i < ret.length - 1; i++) {
                ret[i] = digits[i - 1];
            }
            return ret;
        }
        return digits;
    }
}
