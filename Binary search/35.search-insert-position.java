/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        //binary search
        int n = nums.length;
        int left = 0, right = n-1;
        while(left<=right) {
            int mid = (left+right) /2;
            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid]>target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
// @lc code=end

