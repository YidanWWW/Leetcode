/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    int[] root=null;
    int count;
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, n = isConnected[0].length;
        root = new int[m];
        count = m;

        for(int i=0; i<(m); i++) root[i] = i;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j]==1) merge(i,j);
            }
        }
        return count;
    }

    public int findRoot(int x) {
        if(root[x]==x) return x;
        root[x] = findRoot(root[x]);
        return root[x];
    }
    public void merge(int x, int y){
        x = findRoot(x);
        y = findRoot(y);
        if(x!=y) {
            root[x] = y;
            count--;
        }
    }
}
// @lc code=end

