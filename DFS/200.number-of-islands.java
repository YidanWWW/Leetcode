/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution1 {
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

class Solution {
    int[] root = null;
    int count;
    public int numIslands(char[][] grid) {
        //2. union find
        int m = grid.length, n = grid[0].length;
        int count = m*n;
        root = new int[count];

        for(int i=0; i<count; i++) root[i] = i;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //2d->1d
                if(grid[i][j]=='1') {
                    if(i>0 && grid[i-1][j]=='1') merge(i*n+j, (i-1)*n+j);
                    if(j>0 && grid[i][j-1]=='1') merge(i*n+j, i*n+j-1);
                }else {
                    count--;
                }
            }
        }
        return count;

    }

    public int findRoot(int x) {
        if(x==root[x]) return x;
        root[x] = findRoot(root[x]);
        return root[x];
    }

    public void merge(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);
        if(x!=y) {
            root[x] = y;
            count--;
        }
    }
}


// @lc code=end

