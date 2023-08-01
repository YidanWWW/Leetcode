/*
 * @lc app=leetcode id=1425 lang=java
 *
 * [1425] Constrained Subsequence Sum
 */

// @lc code=start

import java.util.Deque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        Deque<Integer> q = new LinkedList<>(); //decreasing
        int res = nums[0];

        for(int i=0; i<nums.length; i++) {
            nums[i] += q.isEmpty()? 0:q.peekFirst();
            res = Math.max(res, nums[i]);
            while(!q.isEmpty() && nums[i]>q.peekLast()) { //8>10?
                q.pollLast();
            }
            if(nums[i]>0) q.offerLast(nums[i]);
            if(i>=k && !q.isEmpty() && q.peekFirst()==nums[i-k]) q.pollFirst();
        }
        return res;

    }
}
// @lc code=end

