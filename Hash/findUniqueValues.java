import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int findUniqueValues(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0, end = n-1;
        HashSet<Double> set = new HashSet<>();
        while(start<end) {
            double d = (double) (nums[start]+nums[end])/2;
            set.add(d);
            start++;
            end--;
        }
        return set.size();
        
    }
    

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,1,3,5,6};
        int k = 4;
        //int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(findUniqueValues(nums));
    }
}