package perfectSquares279;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 思路：BFS方法
 * 将传入数字循环减去小于自身的完全平方数，得到的数字重复该过程，直到等于0。
 * TODO：优化成动态规划
 */
class Solution {
    public int numSquares(int n) {
        int count = 1;

        Deque<Integer> d = new ArrayDeque<>();
        Set<Integer> used = new HashSet<>();
        d.add(n);

        while (!d.isEmpty()) {
            int size = d.size();
            for(int i = 0; i<size; i++) {
                int cur = d.pop();
                int a = (int) Math.sqrt(cur);
                for (int j = a; j>=1; j--) {
                    int tmp = (int)(cur - Math.pow(j, 2));
                    if (tmp == 0) {
                        return count;
                    } else {
                        if (!used.contains(tmp)) {
                            d.add(tmp);
                            used.add(tmp);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
    }
}
