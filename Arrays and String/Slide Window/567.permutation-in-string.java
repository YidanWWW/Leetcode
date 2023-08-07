/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for(char c:s1.toCharArray()){
            need.put(c, map.getOrDefault(c, 0)+1);
        }

        int start = 0, end = 0, count = 0; //if count==need.size() true
        while(end<s2.length()) {
            char c = s2.charAt(end);
            if(need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0));
                if(map.get(c)==need.get(c)) count++;
            }

            while(end-start+1>s1.length()) {
                //shrink window
                //if(count==need.size()) return true;
                char s = s2.charAt(start);
                if(need.containsKey(s)) {
                    if(need.get(s).equals(map.get(s))) count--;
                    map.put(s, map.get(s)-1);
                }
            }
            if(count==need.size()) return true;
            end++;
        }
        return false;
    }
}
// @lc code=end

