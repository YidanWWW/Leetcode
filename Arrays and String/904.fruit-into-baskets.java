/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0, end = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(; end<fruits.length; end++) {
            map.getOrDefault(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            while(map.size()>2) {
                //shrink this window
                map.put(fruits[start], map.get(fruits[end])-1);
                if(map.get(fruits[start])==0) map.remove(fruits[start]);
                start++;
            }

            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
// @lc code=end

