/**
 * Question: Count the number of k-spikes in the stock price array ,which are counted as k-spikes

A k-spike is an element that satisfies both the following conditions

There are atleast k elements from indices (0,i-1) that are less than prices[i]

There are atleast k elements from indices (i+1,n-1) that are less than prices[i] Examples:
int[] prices = {1, 2, 8, 5, 3, 4}; k=2; Output is 2
int[] prices = {1,3,2,5,4}; k=1; Output is 2
int[] prices = {1,2,8,3,7,5,4}; k=2; Output is 2
int[] prices = {1,2,8,3,7,4,6,5};; k=3; Output is 1
 */

public class Solution {
    public static int countKSpikes(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            int count = 0;
            for(int j=0; j<i; j++) {
                if(nums[j]<cur) count++;
            }
            pre[i] = count;
        }
        
        for(int i=n-1; i>=0; i--) {
            int cur = nums[i];
            int count = 0;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]<nums[i]) count++;
            }
            suf[i] = count;
        } 
        
        for(int i=0; i<n; i++){
            if(suf[i]>=k && pre[i]>=k) res++;
        }
        return res;
    }
    

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,8,3,7,4,6,5};
        int k = 4;
        //int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(countKSpikes(nums, 3));
    }
}
