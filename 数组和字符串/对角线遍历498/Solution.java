package 数组和字符串.对角线遍历498;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 */
class Solution {
    /**
     * O(n平方)解法
     *
     * @param matrix
     * @return
     */
//    public int[] findDiagonalOrder(int[][] matrix) {
//        int row = matrix.length;
//        if (row == 0) {
//            return new int[0];
//        }
//        int col = matrix[0].length;
//        int layer = row + col - 1;
//
//        List<Integer> ret = new ArrayList<>();
//        for (int i = 0; i < layer; i++) {
//            List<Integer> tmp = new ArrayList<>();
//            // 偶数层方向从下往上，奇数层方向从上往下
//            int direction = i % 2 == 0 ? -1 : 1;
//            for (int j = 0; j < row; j++) {
//                int cn = i - j;
//                if (cn<col && cn >= 0) {
//                    if (direction > 0) {
//                        tmp.add(matrix[j][cn]);
//                    } else {
//                        tmp.add(0, matrix[j][cn]);
//                    }
//                }
//            }
//            ret.addAll(tmp);
//        }
//        int[] result = new int[ret.size()];
//        for (int i=0; i < result.length; i++)
//        {
//            result[i] = ret.get(i);
//        }
//        return result;
//    }
    public static void main(String[] args) {
//        int[][] input = {{1,2},{3,4}};
//        int[][] input = {{2,5},{8,4},{0,-1}};
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] input = {};
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(input)));
    }

    /**
     * O(n)解法
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int r = 0;
        int c = 0;
        int col = matrix[0].length;
        int[] ret = new int[row * col];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                // 偶数层，方向从下往上
                if (c == col - 1) {
                    r++;
                } else {
                    if (r == 0) {
                        c++;
                    } else {
                        r--;
                        c++;
                    }
                }
            } else {
                // 奇数层，方向从上往下
                if (r == row - 1) {
                    c++;
                } else {
                    if (c == 0) {
                        r++;
                    } else {
                        r++;
                        c--;
                    }
                }
            }
        }
        return ret;
    }
}
