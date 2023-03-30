package cn.hackzone.leetcode.editor.cn.island;

public class NumberOfIslands {

    static
    class Solution {

        public int numIslands(char[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }
            return ans;
        }

        void dfs(char[][] grid, int w, int h) {
            if (!inArea(grid, w, h)) {
                return;
            }
            if (grid[w][h] != '1') {
                return;
            }

            grid[w][h] = '2';

            dfs(grid, w + 1, h);
            dfs(grid, w - 1, h);
            dfs(grid, w, h + 1);
            dfs(grid, w, h - 1);
        }

        boolean inArea(char[][] grid, int w, int h) {
            return w >= 0 && w < grid.length && h >= 0 && h < grid[0].length;
        }

    }
}
