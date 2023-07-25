/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0)+1);

        //map : num->frequency
        //max heap: from greater to less
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(map.get(b), map.get(a)));
        for(int n : map.keySet()) {
            pq.offer(n);
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
// @lc code=end

