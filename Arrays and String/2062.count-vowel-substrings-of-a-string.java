/*
 * @lc app=leetcode id=2062 lang=java
 *
 * [2062] Count Vowel Substrings of a String
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int countVowelSubstrings(String word) {
        int start = 0, end = 0, mid = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end<word.length()) {
            char endChar = word.charAt(end);
            end++;
            if(endChar=='a' || endChar=='e'|| endChar=='i'|| endChar=='o'|| endChar=='u') {
                map.put(endChar, map.getOrDefault(endChar, 0)+1);
                while(map.size()==5) {
                    //remove middle pointer
                    char midChar = word.charAt(mid);
                    map.put(midChar, map.get(midChar)-1);
                    if(map.get(midChar)==0) map.remove(midChar);
                    mid++;
                }
                res += mid-start;
                
            }else {
                //skip 
                
                start = end;
                mid = end;
                map.clear();
            }
        }
        return res;
    }
}
// @lc code=end

