/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //transfer 2d->1d
        int row = matrix.length, col = matrix[0].length;
        //11, 11/4=2, 11%4=3
        int start = 0, end = row*col-1;
        while(start<=end) {
            int mid = (start+end)/2;
            int x = mid/col, y = mid%col;
            if(matrix[x][y]>target) {
                end = mid-1;
            }else if(matrix[x][y]<target) {
                start = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

