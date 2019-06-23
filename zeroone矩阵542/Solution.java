package zeroone矩阵542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 解题思路：
 * <p>
 * BFS，先遍历矩阵，找到每个0点，作为第一次搜索。
 * 以每个0点出发，向四个方向出发，若任何一个方向的值大于出发点的值+1，所以该点还未被扫描到，将该点的值设置为出发点的值+1，然后再将该点加入下一次搜索的队列中。
 * 循环以上过程，直到队列中没有需要搜索的点。
 */
class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        /**
         * 0 0 0
         * 0 1 0
         * 1 1 1
         */
        int[][] matrix = {{1, 1, 1}, {1, 1, 1}, {1, 1, 0}};
        System.out.println(Arrays.deepToString(new Solution().updateMatrix(matrix)));
    }

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                if (cur == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = row + col;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] direction : directions) {
                int r = direction[0] + poll[0];
                int c = direction[1] + poll[1];
                if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] > matrix[poll[0]][poll[1]] + 1) {
                    matrix[r][c] = matrix[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return matrix;
    }
}
