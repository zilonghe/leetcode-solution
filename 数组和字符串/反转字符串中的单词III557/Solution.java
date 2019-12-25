package 数组和字符串.反转字符串中的单词III557;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] s1 = s.trim().split(" ");
        for (int i = 0; i < s1.length; i++) {
            s1[i] = new StringBuilder(s1[i]).reverse().toString();
        }
        return String.join(" ", s1);
    }
}
