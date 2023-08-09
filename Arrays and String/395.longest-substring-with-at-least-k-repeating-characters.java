/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        //recursion
        if(s.length()==0 || s==null) return 0;
        if(k<2) return s.length();
        int res = 0;
        //build map
        int[] arr = new int[26];
        for(char c:s.toCharArray()) arr[c-'a']++;

        //check if valid
        boolean valid = true;
        int i=0,j=0;
        for(j=0; j<s.length(); j++) {
            if(arr[s.charAt(j)-'a']<k) {
                valid = false; 
                res = Math.max(res, longestSubstring(s.substring(i, j-i), k));
                i = j+1;
            }
        }
        if(valid) return s.length();
        res = Math.max(res, longestSubstring(s.substring(i), k));
        return res;

        
    }
}
// @lc code=end

