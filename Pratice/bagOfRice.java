import java.util.HashSet;
import java.util.Set;

public class MyClass {
    
    public static int BagOfRice(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);
        int res = 0;
        for(int n:set){
            if(!set.contains(Math.sqrt(n))) {
                int count = 1;
                while(set.contains(n*n)) {
                    count++;
                    n = n*n;
                }
                res = Math.max(res, count);
            }
        }
        return res;

    }
    
    public static void main(String args[]) {
 
    int[] nums = new int[]{3,9,4,2,16};
    System.out.print(BagOfRice(nums));
    }
}