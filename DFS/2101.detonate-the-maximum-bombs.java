/*
 * @lc app=leetcode id=2101 lang=java
 *
 * [2101] Detonate the Maximum Bombs
 */

// @lc code=start
class Solution {
    public int maximumDetonation(int[][] bombs) {

        //dfs
        int res = 0, n = bombs.length;
        for(int i=0; i<n; i++) {
            res = Math.max(res, dfs(bombs, new boolean[n], i));
        }
        return res;
        
    }

    public int dfs(int[][] bombs, boolean[] visited, int idx){
        int n=bombs.length;
        int count = 1;
        visited[idx] = true;
        for(int i=0; i<n; i++) {
            if(!visited[i] && inRange(bombs[idx], bombs[i])) {
                count += dfs(bombs, visited, i);
            }
        }
        return count;
    }

    public boolean inRange(int[] a, int[] b) {
        long dx = a[0]-b[0], dy = a[1]-b[1], r=a[2];
        if(dx*dx+dy*dy > r*r) return false;
        return true;
    }
}
// @lc code=end

