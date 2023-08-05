/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution1 {
    //solution1, binary search and then use pointers
    public int[] searchRange(int[] nums, int target) {
        //binary search
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int start = 0, end = nums.length-1;
        int mid = -1;
        if(nums==null) return res;
        while(start<=end) {
            mid = (start+end)/2;
            if(nums[mid]<target) {
                start = mid+1;
            }else if(nums[mid]>target) {
                end = mid-1;
            }else {
                int left = mid, right = mid;
                while(left>=0 && nums[left]==nums[mid]) {
                    left--;
                }
                while(right<nums.length && nums[right]==nums[mid]) {
                    right++;
                }
                res[0] = left+1;
                res[1] = right-1;
                return res;
            }
        }
        return res;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = helper(nums, target, 0, nums.length - 1);
        int right = helper(nums, target + 1, left, nums.length - 1);

        if (left < nums.length && nums[left] == target) {
            // Target found
            return new int[]{left, right - 1};
        } else {
            // Target not found
            return new int[]{-1, -1};
        }
    }

    private int helper(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

// @lc code=end

