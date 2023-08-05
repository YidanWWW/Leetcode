/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int num = 0, res = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for(char c : s.toCharArray()) {
            //consider some conditions

            //1. digit
            if(Character.isDigit(c)) {
                //update number
                num = 10*num + (int)(c-'0');
            }else if(c=='+' || c=='-') {
                res += sign*num;
                sign = stack.peek() * (c=='+'?1:-1);
                num = 0;
            }else if(c=='('){
                stack.push(sign);
            }else if(c==')') {
                stack.pop(); //pop the sign
            }
        }
        res += sign*num; //process the last digit
        return res;
    }
}
// @lc code=end

