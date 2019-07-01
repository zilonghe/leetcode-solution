package 数组和字符串.螺旋矩阵54;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution {

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(new Solution().spiralOrder(input));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        List<Integer> ret = new ArrayList<>();
        int r = 0;
        int c = 0;
        int di = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row * col; i++) {
            ret.add(matrix[r][c]);
            visited[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (cr >= row || cr < 0 || cc < 0 || cc >= col || visited[cr][cc]) {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            } else {
                r = cr;
                c = cc;
            }
        }
        return ret;
    }
}
