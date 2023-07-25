/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //int res = 0;
        int end = 0, start = 0;
        //slide windows
        //Deque
        Deque<Integer> maxd = new LinkedList<>();
        Deque<Integer> mind = new LinkedList<>();

        for(end=0; end<nums.length; ++end) {
            while(maxd.size()>0 && nums[end]>maxd.peekLast()) {
                maxd.pollLast();
            }
            while(mind.size()>0 && nums[end]<mind.peekLast()) {
                mind.pollLast();
            }

            maxd.add(nums[end]);
            mind.add(nums[end]);

            if(maxd.peek() - mind.peek() > limit) {
                if(mind.peek() == nums[start]) mind.poll();
                if(maxd.peek() == nums[start]) maxd.poll();
                start++;
            }
            //res = Math.max(res, end-start);
            
        }
        return end-start;

    }
}
// @lc code=end

