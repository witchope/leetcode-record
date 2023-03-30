package cn.hackzone.leetcode.editor.cn.island;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * <a href="https://leetcode.cn/problems/max-area-of-island">链接</a>
 */
public class MaxAreaOfIsland {

    static
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int area = area(grid, i, j);
                        ans = Math.max(area, ans);
                    }
                }
            }
            return ans;
        }

        int area(int[][] grid, int i, int j) {
            if (!inArea(grid, i, j)) {
                return 0;
            }
            if (grid[i][j] != 1) {
                return 0;
            }

            grid[i][j] = 2;

            return area(grid, i + 1, j)
                    + area(grid, i - 1, j)
                    + area(grid, i, j + 1)
                    + area(grid, i, j - 1)
                    + 1;
        }


        boolean inArea(int[][] grid, int w, int h) {
            return w >= 0 && w < grid.length && h >= 0 && h < grid[0].length;
        }
    }

}
