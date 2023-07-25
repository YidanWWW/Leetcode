/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //prefix sum ->frequency
        //sum[i]-sum[j] = sum[j.... i-1] =k
        int sum = 0, res = 0;

        for(int i=1; i<=nums.length; i++) {
            sum += nums[i-1];
            if(map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
        
    }
}
// @lc code=end

