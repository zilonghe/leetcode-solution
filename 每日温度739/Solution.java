package 每日温度739;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数
 */
class Solution {
    // 最原始的解法，双循环硬解
//    public int[] dailyTemperatures(int[] T) {
//        int[] ret = new int[T.length];
//        for(int i = 0; i < T.length; i++) {
//            int count = 0;
//            for(int j = i+1; j<T.length; j++) {
//                if(i==T.length-1) {
//                    break;
//                }
//                ++count;
//                if (T[j] > T[i]) {
//                    ret[i] = count;
//                    break;
//                }
//            }
//        }
//        return ret;
//    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] T = {73};
        for (int i : new Solution().dailyTemperatures(T)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 1.只有倒序遍历数组处理才能在O(n)完成，顺序处理的话就像上面那样处理，
     * 因为你只有遍历完整个数组，才能确定有没有比当前位置的数大的数。
     * 2.如果倒序处理，肯定不能反着来找，就是找到第一个比自己小的数，那这样倒序处理将毫无意义
     * 所以倒序处理，同样是找到在已经‘存储’的数中，比自己大的数，如果没有那就是0，那自己就是最大值
     * 比当前数字先处理的（也就是在这个数后面的），并且<=当前位置的数，都可以去掉。
     * 3.因为要找到自己和比自己大的数相差的天数，也就是位置的差数，所以我们存储的是下标，对比的是数值
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            //1.如果栈不是空的，对比栈顶和当前数字大小，若比当前数字小，则pop掉，直到找到一个比自己大的数或者栈空为止
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            //2.如果栈空，说明当前数字是最大的，则结果是0，否则用栈顶的下标减去当前下标等于结果
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
