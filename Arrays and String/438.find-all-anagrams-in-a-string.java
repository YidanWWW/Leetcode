/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        if(m<n) return res;
        int[] arr = new int[26];
        for(char c:p.toCharArray()) arr[c-'a']++;

        int start = 0, end = 0;

        while(end<m) {
            char endChar = s.charAt(end);
            arr[endChar-'a']--;
            while(arr[endChar-'a']<0) {
                arr[s.charAt(start)-'a']++;
                start++;
            }
            if(end-start+1==n) res.add(start);
            end++;
        }
        return res;
    }
}
// @lc code=end

