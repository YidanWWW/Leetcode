/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;

class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s = countAndSay(n-1);
        return helper(s);
    }
    
    public String helper(String s) {
        //s = "111221" ->312211
        StringBuilder sb = new StringBuilder();
        int count = 1;
        //int end = 0;
        for(int i=0; i<s.length(); i++) {
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
            count = 1;

        }

        return sb.toString();


    }
}
// @lc code=end

