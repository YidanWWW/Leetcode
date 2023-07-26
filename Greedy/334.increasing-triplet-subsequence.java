/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num<=left) {
                left=num;
            }else if(num<=right) {
                right=num;
            }else if(right<num){
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

