/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        //greedy
        //prevDiff and curDiff
        //if wiggle, update prevDiff
        int prevDiff = 0, curDiff = 0, res = 1;
        for(int i=0; i<nums.length-1; i++) {
            curDiff = nums[i+1]-nums[i];
            if((curDiff>0 && prevDiff<=0) || (curDiff<=0 && prevDiff>0)) {
                res++;
                prevDiff = curDiff;
            }
        }
        return res;
    }
}
// @lc code=end

