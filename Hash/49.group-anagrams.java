/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String ns = new String(chars);
            if(map.containsKey(ns)) {
                map.get(ns).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(ns, list);
            }
        }

        for(List<String> l : map.values()) {
            res.add(l);
        }
        return res;

    }
}
// @lc code=end

