/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //two pointers:i,j
        //1112
        //j: keep track of the current index where a unique element shoule be p;aced
        int i=1, j=1;
        for(;i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
// @lc code=end

