/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        for(int i=right; i<=right; i++) {
            if(nums[i] == 0) {
                nums[left] = 0;
                left++;
            }else if(nums[i] == 2) {
                nums[right] = 2;
                right--;
            }
        }
        for(int i=left; i<=right; i++) {
            nums[i] = 1;
        }
        
    }
}
// @lc code=end

