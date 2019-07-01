package 数组和字符串.杨辉三角118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        if (numRows == 0) {
            return ret;
        }
        int[][] matrix = new int[numRows][numRows];
        matrix[0][0] = 1;
        for (int i = 2; i <= numRows; i++) {
            for (int j = 0; j < i; j++) {
                int p = (i - 2 >= 0 && j - 1 >= 0) ? matrix[i - 2][j - 1] : 0;
                int q = i - 2 >= 0 ? matrix[i - 2][j] : 0;
                matrix[i - 1][j] = p + q;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            List<Integer> tmp = new ArrayList<>(matrix[i].length);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    tmp.add(matrix[i][j]);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
