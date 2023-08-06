/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return res;
        backTracking(nums, 0);
        return res;
    }
    public void backTracking(int[] nums, int idx) {
        res.add(new ArrayList<>(path));

        for(int i=idx; i<nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

