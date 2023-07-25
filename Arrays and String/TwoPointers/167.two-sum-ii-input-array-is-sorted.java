/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n-1;
        int[] res = new int[2];
        while(right>left) {
            int sum = numbers[right] + numbers[left];
            if(sum==target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }else if(sum>target) {
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

