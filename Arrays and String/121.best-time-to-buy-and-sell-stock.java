/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //slide windows
        int start = 0, end = 1, res = 0;
        while(end<prices.length) {
            if(prices[end]>prices[start]) {
                res = Math.max(res, prices[end]-prices[start]);
                end++;
            }else {
                start = end;
                end++;
            }
        }
        return res;
    }
}
// @lc code=end

