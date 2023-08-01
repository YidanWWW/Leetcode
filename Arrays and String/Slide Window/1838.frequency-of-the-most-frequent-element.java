/*
 * @lc app=leetcode id=1838 lang=java
 *
 * [1838] Frequency of the Most Frequent Element
 */

// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        //sort
        //k+sum >= nums[j](j-i+1)

        int start = 0, end = 0, res = 0;
        long sum = 0;
        Arrays.sort(nums);
        while(end<nums.length) {
            sum += nums[end];

            while(sum+k < (long)nums[end]*(end-start+1)) {
                sum-=nums[start];
                start++;
            }

            res = Math.max(res, end-start+1);
            end++;
        }
        return res;
    }
}
// @lc code=end

