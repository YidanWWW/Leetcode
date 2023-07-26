/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for(int i=0; i<intervals.length; i++) {
            int curStart = intervals[i][0], curEnd = intervals[i][1];
            if(curEnd<start) {
                res.add(new int[]{curStart, curEnd});
            }else if(curStart>end){
                res.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            }else {
                start = Math.min(curStart, start);
                end = Math.max(curEnd, end);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);

    }
}
// @lc code=end

