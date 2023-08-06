/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    StringBuilder path = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return res;
        String[] nums = {"", "", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(nums, digits, 0);
        return res;
    }

    public void backTracking(String[] nums, String digits, int start) {
        if(start==digits.length()) {
            res.add(path.toString());
            return;
        }

        String num = nums[digits.charAt(start)-'0'];
        for(int i=0; i<num.length(); i++) {
            path.append(num.charAt(i));
            backTracking(nums, digits, start+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
// @lc code=end

