/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int pre = getValue(s.charAt(0));
        int sum = 0;
        for(int i=1; i<s.length(); i++) {
            int cur = getValue(s.charAt(i));
            if(cur>pre) {
                sum -= pre;
            }else {
                sum += pre;
            }
            pre = cur;
        }
        sum += pre;
        return sum;
    }

    public int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// @lc code=end

