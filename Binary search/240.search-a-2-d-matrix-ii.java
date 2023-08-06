/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(m+n)
        int m = matrix.length, n =matrix[0].length;
        int i=0, j=n-1;
        while(i<m && j>=0){
            if(matrix[i][j]>target) {
                j--; //go left
            }else if(matrix[i][j]<target) {
                i++; // go down
            }else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

