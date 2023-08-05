package TwoPointers;
/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();//words
        //to reduce redundant calculation，we need to use map, string-frequency
        for(String word:words) map.put(word, map.getOrDefault(word, 0)+1);

        for(String word:map.keySet()) {
            if(isSebsequence(s, word)) {
                count+=map.get(word);
            }
        }
        return count;
    }

    public boolean isSebsequence(String s1, String s2) {
        int i=0, j=0;
        while(i<s1.length() && j<s2.length()) {
            if(s1.charAt(i)==s2.charAt(j)) {
                i++;
                j++;
            }else {
                i++;
            }
        }

        return j==s2.length();
    }
}
// @lc code=end

