/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //calculate the number of non-overlaping array, and use len to minus it to get the result
        int n = 1;
        int len = intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        if(len==1) return 0;
        int[] newInterval = new int[2];
        newInterval[0] = intervals[0][0];
        newInterval[1] = intervals[0][1];

        for(int i=0; i<len; i++) {
            if(newInterval[1]>intervals[i][0]) {
                newInterval[0] = Math.max(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.min(newInterval[1], intervals[i][1]);
            }else {
                n++;
                newInterval = intervals[i];
            }
        }
        return len-n;
    }
}
// @lc code=end

