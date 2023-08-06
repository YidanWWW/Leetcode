/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, 0);
        return res;
    }

    public void backTracking(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

