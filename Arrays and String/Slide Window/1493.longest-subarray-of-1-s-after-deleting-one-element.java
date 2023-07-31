/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int k = 1;
        while(end<nums.length) {
            if(nums[end]==0) k--;

            while(k<0) {
                //shrink window
                if(nums[start]==0) k++;
                start++;
            }
            res = Math.max(res, end-start);
            end++;
        }
        return res;
    }
}
// @lc code=end

