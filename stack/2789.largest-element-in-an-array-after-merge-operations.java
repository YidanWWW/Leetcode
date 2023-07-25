/*
 * @lc app=leetcode id=2789 lang=java
 *
 * [2789] Largest Element in an Array after Merge Operations
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public long maxArrayValue(int[] nums) {
        //notice: long
        Stack<Long> stack = new Stack<>();
        int len = nums.length;
        if(len==1) return nums[0];
        long res = 0;
        for(int i=len-1; i>=0; i--) {
            if(!stack.isEmpty() && stack.peek()>=nums[i]) {
                stack.push(stack.pop()+nums[i]);
            } else {
                stack.push((long)nums[i]);
            }

            res = Math.max(res, stack.peek());
        }
        return res;
    }
}
// @lc code=end

