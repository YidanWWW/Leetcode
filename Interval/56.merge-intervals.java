/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int[] newInterval = new int[2];
        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i<n; i++){
            //3 conditions
            int[] interval = new int[]{intervals[i][0], intervals[i][1]};
            if(newInterval[1]<interval[0]) {
                res.add(newInterval);
                newInterval = interval;
            }else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);

    }
}
// @lc code=end

