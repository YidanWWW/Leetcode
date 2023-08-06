/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, 0, 0, target);
        return res;
    }

    public void backTracking(int[] nums, int start, int sum, int target) {
        if(sum==target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<nums.length; i++) {
            if(sum+nums[i] > target) continue;  
            sum += nums[i];
            path.add(nums[i]);
            backTracking(nums, i, sum, target); //bec a element can be used for unlimited times,so i but not i+1
            sum -=nums[i];
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

