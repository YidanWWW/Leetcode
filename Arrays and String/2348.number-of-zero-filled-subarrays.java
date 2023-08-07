/*
 * @lc app=leetcode id=2348 lang=java
 *
 * [2348] Number of Zero-Filled Subarrays
 */

// @lc code=start
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long length = 0;
        for(int n:nums) {
            if(n==0) {
                length++;
                res += length;
            }else {
                length=0;
            }
        }
        return res;

    }
}
// @lc code=end

