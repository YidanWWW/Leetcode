/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 */

// @lc code=start
class Solution {
    // brute force
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = helper(intervals, intervals[i][1]);
        }
        return res;
    }

    public int helper(int[][] intervals, int end) {
        int idx = -1, min = Integer.MAX_VALUE; //find start>end

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] > end && min>intervals[i][0]) {
                min = intervals[i][0];
                idx = i;
            }
        }
        return idx;
    }
}
// @lc code=end

