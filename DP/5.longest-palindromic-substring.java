/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        //dynamic programming
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //from i->j,if it is palindrome, true
        if(n==1) return s;
        int maxLen = 0;

        //len==1
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            maxLen = 1;
        }

        //len = 2

        int start = 0;
        for(int i=1; i<n; i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                dp[i-1][i] = true;
                start = i-1;
                maxLen = 2;
            }
        }

        //len=3
        for(int len=3; len<=n; len++) {
            for(int i=0; i+len-1<n; i++) {
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
// @lc code=end

