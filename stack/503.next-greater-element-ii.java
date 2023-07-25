/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //circular integer array, 2*n
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;

        for(int i=0; i<2*n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]){
                res[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }

        return res;

    }
}
// @lc code=end

