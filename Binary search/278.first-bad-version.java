/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1, right = n;
        
        while(left<=right) {
            long mid = (right+left)/2; //1,2,3,4,5 -> f,f,f,t,t return 4
            if(isBadVersion((int)mid)) {
                right = (int)mid-1;
            }else {
                left = (int)mid+1;
            }
        }
        return (int)left;
    }
}
// @lc code=end

