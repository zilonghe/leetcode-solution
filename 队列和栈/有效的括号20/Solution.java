package 队列和栈.有效的括号20;

import java.util.*;

class Solution {
    private static Map<Character, Character> M = new HashMap<>(3);

    public Solution() {
        M.put('}', '{');
        M.put(']', '[');
        M.put(')', '(');
    }

    public boolean isValid(String s) {
        Stack<Character> cl = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (M.containsKey(cur)) {
                if (cl.isEmpty()) {
                    return false;
                }
                if (!cl.pop().equals(M.get(cur))) {
                    return false;
                }
            } else {
                cl.push(cur);
            }
        }
        return cl.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
        System.out.println(new Solution().isValid("(])"));
    }
}
