/*
 * @lc app=leetcode id=2401 lang=java
 *
 * [2401] Longest Nice Subarray
 */

// @lc code=start
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0, end = 0, AND = 0, res = 1;
        while(end<nums.length){
            while((AND & nums[end]) > 0) {
                AND ^= nums[start]; //remove the start element
                start++;
            }
            AND |= nums[end];
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;
    }
}
// @lc code=end

