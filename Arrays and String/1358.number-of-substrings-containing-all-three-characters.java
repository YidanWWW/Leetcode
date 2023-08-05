/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        //abcabc->abc, abca, abca,bca...
        //slide window
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, res = 0, mid = 0;
        int len = s.length();
        if(len<3) return 0;

        while(end<len) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.size()==3) {
                char m = s.charAt(mid);
                map.put(m, map.get(m)-1);
                if(map.get(m)==0) map.remove(m);
                mid++;
            }
            res += mid-start;
            end++;
        }
        return res;
    }
}
// @lc code=end

