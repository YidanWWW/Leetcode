/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char positive = '+';
        for(char c:chars) {
            if(c==' ') continue;
            if(sb.length()==0 && Character.isLetter(c)) continue;
            if(c=='0' && sb.length()==0){
                continue;
            }else if(Character.isDigit(c)) {
                sb.append(c);
            }else if(c=='-'){
                positive = '-';
            }
        }
        String res = sb.toString();
        int result = 0;
        int count = 1;
        for(int i=res.length()-1; i>=0; i--) {
            int c = res.charAt(i)-'0';
            result += count*c;
            count *= 10;
        }
        return positive=='-'?-result:result;

    }
}
// @lc code=end

