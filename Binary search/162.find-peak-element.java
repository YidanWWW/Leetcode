/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==0) return 0;
        int left = -1, right = nums.length;
        while(left+1!=right) {
            int mid = left +(right-left)/2;
            int lvalue = mid-1>=0?nums[mid-1]:-1;
            int rvalue = mid+1<nums.length?nums[mid+1]:-1;

            if(lvalue<=nums[mid] && nums[mid]<=rvalue) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
// @lc code=end

