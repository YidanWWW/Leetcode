/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int res = Integer.MIN_VALUE;
        while(end<nums.length) {
            if(nums[end]==0) k--;
            
            while(k<0) {
                //shrink
                if(nums[start]==0) k++;
                start++;
            }
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;
    }
}
// @lc code=end

