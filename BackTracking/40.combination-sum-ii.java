/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }
    public void backTracking(int[] nums, int target, int start, int sum) {
        if(sum==target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            if(sum+nums[i]>target) continue;
            sum += nums[i];
            path.add(nums[i]);
            backTracking(nums, target, i+1, sum);
            sum -= nums[i];
            path.remove(path.size()-1);
        }
    } 
}
// @lc code=end

