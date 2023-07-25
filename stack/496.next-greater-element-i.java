/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //1. find every position of nums1 in nums2(HashMap)
        //2. calculate every value's greater element
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];

        for(int num:nums2) {
            //key:nums2[i], value->correspomding greater number
            while(!stack.isEmpty() && num>stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i=0; i<nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
        
    }
}
// @lc code=end

