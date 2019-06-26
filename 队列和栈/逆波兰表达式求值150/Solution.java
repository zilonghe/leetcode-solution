package 队列和栈.逆波兰表达式求值150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
//        String[] i = new String[]{"2", "1", "+", "3", "*"};
//        String[] i = new String[]{"4", "13", "5", "/", "+"};
        String[] i = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(i));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        Set<String> ops = new HashSet<>(4);
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for (String i : tokens) {
            Integer second;
            Integer first;
            switch (i) {
                case "+":
                    second = s.pop();
                    first = s.pop();
                    s.push(first + second);
                    break;
                case "-":
                    second = s.pop();
                    first = s.pop();
                    s.push(first - second);
                    break;
                case "*":
                    second = s.pop();
                    first = s.pop();
                    s.push(first * second);
                    break;
                case "/":
                    second = s.pop();
                    first = s.pop();
                    s.push(first / second);
                    break;
                default:
                    s.push(Integer.valueOf(i));
            }
        }
        return s.peek();
    }
}
