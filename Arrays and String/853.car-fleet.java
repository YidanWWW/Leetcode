/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==1) return 1;
        double[][] time = new double[n][2];

        for(int i=0; i<n; i++) {
            time[i][0] = position[i];
            time[i][1] = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(time, (a,b)->Double.compare(a[0], b[0])); //from greater to less

        double max = time[n-1][1];
        int res = 1;

        for(int i=n-2; i>=0; i--) {
            double cur = time[i][1];
            if(cur>max) {
                max = cur;
                res++;
            }
        }

        return res;
    }
}
// @lc code=end

