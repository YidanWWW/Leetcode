/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        //1,3,5,6, target = 1
        int left = 0, right = nums.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(nums[mid]==target) {
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
// @lc code=end

