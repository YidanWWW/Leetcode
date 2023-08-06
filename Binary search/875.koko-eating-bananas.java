/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = getMax(piles)+1;

        while(left<right){
            int mid = (left+right)/2;
            int hour = 0;

            for(int pile:piles){
                hour+=pile/mid;
                if(pile%mid !=0) hour++;
            }

            if(hour<=h){
                right = mid;
            }else if(hour>h){
                left = mid+1;
            }
        }
        return left;
    }
    public int getMax(int[] piles){
        int max = 0;
        for(int pile:piles){
            max = Math.max(max, pile);
        }
        return max;
    }
}
// @lc code=end

