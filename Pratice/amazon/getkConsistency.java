package amazon;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
   public static int getKConsistency(int[] nums, int k) {
       //[7,5,7,7,1,1,7,7] ,k=3
       int res = 0;
       HashSet<Integer> set = new HashSet<>();
       for(int n:nums) set.add(n);
       for(int n: set) {
           int start = 0, end = 0, count = 0;
           while(end<nums.length){
               if(nums[end]!=n) count++;
               while(count>k) {
                   if(nums[start]!=n) count--;
                   start++;
               }
               res = Math.max(res, end-start+1-count);
               end++;
           }
       }
       return res;
        
    }

    public static void main(String[] args) {
        int[] a1 = {7,5,7,7,1,1,7,7};
        int[] a2 = {1,1,2,1,2,1};
        System.out.println(getKConsistency(a1, 3));
        System.out.println(getKConsistency(a2, 3));
        
    }
}
