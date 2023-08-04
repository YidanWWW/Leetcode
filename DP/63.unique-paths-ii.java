/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //from 0,0 -> m-1,n-1, if(obstacleGrid[m][n]==1) there is an abstacle
        
        //initialize dp array
        for(int i=0; i<m && obstacleGrid[i][0]==0; i++) dp[i][0] = 1;
        for(int j=0; j<n && obstacleGrid[0][j]==0; j++) dp[0][j] = 1;

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j]!=1) dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

