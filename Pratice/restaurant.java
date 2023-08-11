import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.List;
//973. K Closest Points to Origin

public class Solution {
   public static List<int[]> getKConsistency(int[][] nums, int k) {
       //nearest restaurant
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]));
        
        for(int[] n:nums) {
            pq.offer(n);
        }
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(pq.poll());
        }
        return res;
        
    }

    public static void main(String[] args) {
        int[][] a1 = new int[][] {{1, 2}, {3, 4}, {1, -1}};
        List<int[]> result = getKConsistency(a1, 2);
        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
        
    }
}