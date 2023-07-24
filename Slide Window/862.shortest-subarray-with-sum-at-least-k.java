/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        //prefix sum [1, 0, -2, 3]-> [0, 1, 1, -1, 2]
        //1. brute force: enum all subarrays satisfying the condition where i>j and s[i]-s[j]>=k
        //2. optimize: deque d keeps indexes of increasing preSum[i]
        //   for every preSum[i], we will compare nums[i]-nums[d[0]] with k

        int len = nums.length;
        long[] preSum = new long[len+1];
        preSum[0] = 0;
        int res = len+1;
        Deque<Integer> d = new ArrayDeque<>();
        for(int i=1; i<=len; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
            // for(int j=0; j<i; j++) {
            //     if(preSum[i]-preSum[j]>=k) res = Math.min(res, i-j);
            // }
        }

        for(int i=0; i<len+1; i++) {
            while(d.size() >0 && preSum[i]-preSum[d.getFirst()]>=k) {
                res = Math.min(res, i-d.pollFirst());
            }

            while(d.size()>0 && preSum[i]<=preSum[d.getLast()]) {
                d.pollLast();
            }

            d.addLast(i);
        }

        return res<=len?res:-1;

    }
}
// @lc code=end

