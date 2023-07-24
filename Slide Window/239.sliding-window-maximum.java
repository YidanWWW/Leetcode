/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //prefix sum [1, 0, -2, 3]-> [0, 1, 1, -1, 2]
        //1. brute force: enum all subarrays satisfying the condition where i>j and s[i]-s[j]>=k
        //2. optimize: deque d keeps indexes of increasing preSum[i]
        //   for every preSum[i], we will compare nums[i]-nums[d[0]] with k
        
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        int sum = 0, res = nums.length+1;

        for(int i=1; i<=nums.length; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
            for(int j=0; j<i; j++) {
                if(preSum[i]-preSum[j]>=k) res = Math.min(res, i-j);
            }
        }
        return res == (nums.length+1)?-1:res;

        // Deque<Integer> d = new ArrayDeque<>();
        // for(int i=0; i<=nums.length; i++) {
        //     while(d.size)
        // }
    }
}
// @lc code=end

