/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        //XOR
        if(nums.length==1) return nums[0];

        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            res ^= nums[i];
        }
        return res;

    }
}
// @lc code=end

