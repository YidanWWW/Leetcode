package amazon;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String args[]) {
      int[] p = new int[]{2,1,4,6,1};
      int[] b = new int[]{2,1,4,6,1};
      System.out.println(findMaximumSustainableClusterSize(p, b, 40));
    }
    

    public static int findMaximumSustainableClusterSize(int[] processing, int[] boot, long powerMax){
        int res = 0;
        int m = processing.length;
        int n = boot.length;
        //use deque to keep track of booting power, use slide window keep track of processing
        int start = 0, end = 0;
        long sum = 0;
        Deque<Integer> q = new LinkedList<>();
        while(end<m) {
            sum += processing[end];
            //increasing
            while(!q.isEmpty() && boot[q.peekLast()]<boot[end]) {
                q.pollLast();    
            }

            q.offerLast(end);
            while(start<=end && sum*(end-start+1) + boot[q.peekFirst()] >powerMax) {
                //shrink window
                sum-=processing[start];
                start++;
                while(!q.isEmpty() && q.peekFirst()<end-start) {
                    q.pollFirst();
                }
            }
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;

        
    }

}