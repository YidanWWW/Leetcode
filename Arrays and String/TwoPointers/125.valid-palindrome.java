/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        
        while(right>left) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }
            if(Character.toLowerCase(r)!=Character.toLowerCase(l)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

