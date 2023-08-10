/*
 * @lc app=leetcode id=2294 lang=java
 *
 * [2294] Partition Array Such That Maximum Difference Is K
 */

// @lc code=start
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, max = nums[0], min = nums[0];
        for(int n:nums) {
            max = Math.max(max, n);
            if(max-min > k) {
                res++;
                max = min = n;
            }
        }
        return res;
    }
}
// @lc code=end

