/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        //)( false
        int left = 0, right = 0;
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='*') left++;
            if(c==')') right++;
            if(right>left) return false;
        }

        // )(
            left=0;
            right=0;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(c==')' || c=='*') right++;
            if(c=='(') left++;
            if(left>right) return false;
        }
        return true;
    }
}
// @lc code=end

