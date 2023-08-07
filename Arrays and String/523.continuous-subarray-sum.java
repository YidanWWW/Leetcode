/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //hashmap:key:sum%k, value:index
        //23%6=5, 25%6=1, 29%6=5
        //29-23 = 6
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,0);
        int sum = 0;
        for(int i=1; i<=nums.length; i++) {
            sum += nums[i-1];
            // preSum[i]-preSum[j], i-j>=2
            if(map.containsKey(sum%k)) {
                if(i-map.get(sum%k)>=2) {
                    return true;
                }
            }else {
                map.put(sum%k, i);
            }
        }
        return false;
    }
}
// @lc code=end

