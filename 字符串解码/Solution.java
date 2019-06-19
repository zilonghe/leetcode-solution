package 字符串解码;

import java.util.ArrayList;
import java.util.List;
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
    private Stack<Character> operStack = new Stack<>();
    private Stack<Character> charStack = new Stack<>();

    public String decodeString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ']') {
                // pop the '['
                operStack.pop();
                // pop the repeat count
                StringBuilder countSb = new StringBuilder();
                while (!operStack.isEmpty() && Character.isDigit(operStack.peek())) {
                    countSb.append(operStack.pop());
                }
                int count = Integer.parseInt(countSb.reverse().toString());
                List<Character> tmpList = new ArrayList<>();
                while (charStack.peek() != '-') {
                    tmpList.add(charStack.pop());
                }
                charStack.pop();

                String s1 = multiString(count, tmpList);
                for (int i1 = 0; i1 < s1.length(); i1++) {
                    charStack.push(s1.charAt(i1));
                }
            } else {
                if (cur == '[' || Character.isDigit(cur)) {
                    operStack.push(cur);
                    if (!Character.isDigit(cur)) {
                        charStack.push('-');
                    }
                } else {
                    charStack.push(cur);
                }
            }
        }
        StringBuilder builder = new StringBuilder(charStack.size());
        for (Character character : charStack) {
            builder.append(character);
        }
        return builder.toString();
    }

    private String multiString(int count, List<Character> characters) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(getReverseStringRepresentation(characters));
        }
        return result.toString();
    }

    private String getReverseStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().decodeString("3[a]2[bc]"));
//        System.out.println(new Solution().decodeString("3[a2[c]]"));
//        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
//    }
}
