/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]));
        for(int[] point:points) {
            pq.offer(point);
        }

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<k; i++) {
            list.add(pq.poll());
        }
        int[][] res = new int[list.size()][];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
// @lc code=end

