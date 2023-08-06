/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums[end]>nums[start]) return nums[0];
        while(start+1!=end) {
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[start]) {
                start = mid;
            }else {
                end = mid;
            }
        }
        return nums[end];
    }
}
// @lc code=end

