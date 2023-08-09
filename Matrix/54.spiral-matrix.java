/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //4: top, bottom, left, right top<=bottom, left<=right
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom=m-1, left=0,right=n-1;
        List<Integer> res = new ArrayList<>();

        while(top<=bottom && left<=right) {
            //from left to right
            for(int i=left; i<=right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            //from top to bottom
            for(int i=top; i<=bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            //from right to left
            if(top<=bottom) { //must make sure top<=bottom
                for(int i=right; i>=left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //from bottom to top
            if(left<=right){
                for(int i=bottom; i>=top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

