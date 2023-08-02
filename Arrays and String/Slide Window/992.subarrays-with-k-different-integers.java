/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int helper(int[] nums, int k) {
       int start = 0, end = 0, res = 0;
       HashMap<Integer, Integer> map = new HashMap<>();
       while(end<nums.length) {
           map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
           while(map.size()>k) {
               //shrink this window
               map.put(nums[start], map.get(nums[start])-1);
               if(map.get(nums[start])==0) map.remove(nums[start]);
               start++;
           }
           res += end-start+1;
           end++;
       }
       return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        //exactly(k) = atMost(k)-atMost(k-1)
        return helper(nums, k)-helper(nums, k-1);
    }
}
// @lc code=end

