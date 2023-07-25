/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len==0 || k==0) return new int[0];
        int[] res = new int[len-k+1];
        Deque<Integer> d = new LinkedList<>();

        for(int i=0; i<len; i++) {
            //remove the indices that are out of bound
            while(d.size()>0 && d.peekFirst()<=i-k) {
                d.pollFirst();
            }
            //remove indices whose corresponding value is less than nums[i]
            
            while(d.size()>0 && nums[d.peekLast()]<=nums[i]) {
                d.pollLast();
            }

            d.offerLast(i);
            if(i-k+1>=0) res[i-k+1] = nums[d.peekFirst()];
        }
        return res;
    }
}
// @lc code=end

