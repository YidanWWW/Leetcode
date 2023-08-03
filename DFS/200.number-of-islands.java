/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        //1.DFS
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    public void dfs(char[][] grid, int i, int j) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]=='1') {
            grid[i][j] = '0';
            for(int[] d:dirs) {
                int x = d[0]+i, y = d[1]+j;
                dfs(grid, x, y);
            }
        }
    }
}
// @lc code=end

