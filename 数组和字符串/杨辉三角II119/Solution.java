package 数组和字符串.杨辉三角II119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        rowIndex++;
        int[][] matrix = new int[rowIndex][rowIndex];
        matrix[0][0] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 0; j < i; j++) {
                int p = (i - 2 >= 0 && j - 1 >= 0) ? matrix[i - 2][j - 1] : 0;
                int q = i - 2 >= 0 ? matrix[i - 2][j] : 0;
                matrix[i - 1][j] = p + q;
            }
        }

        for (int i = 0; i < matrix[rowIndex - 1].length; i++) {
            if (matrix[rowIndex - 1][i] != 0) {
                ret.add(matrix[rowIndex - 1][i]);
            }
        }
        return ret;
    }
}
