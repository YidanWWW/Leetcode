/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //1,2,3,4
        backTracking(n,k,1);
        return res;
    }

    public void backTracking(int n, int k, int start) {
        if(path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<=n; i++) {
            path.add(i);
            backTracking(n, k, i+1);
            path.remove(path.size()-1);
        }

    }
}
// @lc code=end

