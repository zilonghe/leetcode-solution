package 队列和栈.字符串解码;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
class Solution {
    private Stack<String> p = new Stack<>();

    /**
     * 将所有非']'的符号入栈
     * 遇到']'时，把'['和']'之间的所有字符出栈记录
     * 把'['出栈
     * 把'['前的数字解析成整形
     * 将计算好的字符串入栈
     */
    public String decodeString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ']') {
                String tmp = "";
                while (!"[".equals(p.peek())) {
                    tmp = p.pop() + tmp;
                }
                p.pop();

                String countString = "";
                while (!p.isEmpty() && Character.isDigit(p.peek().charAt(0))) {
                    countString = p.pop() + countString;
                }
                int count = Integer.parseInt(countString);

                String ret = "";
                for (int i1 = 0; i1 < count; i1++) {
                    ret += tmp;
                }
                p.push(ret);
            } else {
                p.push("" + cur);
            }
        }
        String result = "";
        while (!p.isEmpty()) {
            result = p.pop() + result;
        }
        return result;
    }
//    public static void main(String[] args) {
//        System.out.println(new Solution().decodeString("3[a]2[bc]"));
//        System.out.println(new Solution().decodeString("3[a2[c]]"));
//        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
//        System.out.println(new Solution().decodeString("10[abc]"));
//    }
}
