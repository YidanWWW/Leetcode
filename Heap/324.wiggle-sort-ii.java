/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start

import java.util.PriorityQueue;

import javax.management.QueryExp;

class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:nums) pq.offer(n);

        //[4,5,5,6], consider identical element, so we insert greater part
        for(int i=1; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }

        for(int i=0; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }



    }
}
// @lc code=end

