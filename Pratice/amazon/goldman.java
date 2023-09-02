package amazon;
import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      int[] a = new int[]{1,5,4,10,9};

      System.out.println(solution(a, 3));
    }
    
    public static List<Integer> solution(int[] A, int[][] queries) {
        //A[X-1] = A[X-1]-Y, x=q[i][0], y = q[i][1]
        //B[0]=A[0] and B[i] = min( A[i] , B[i-1] )
        List<Integer> result = new ArrayList<>();
        for(int[] q:queries) {
            int x = query[0];
            int y = query[1];
            A[x-1] -= y;
            Set<Integer> set = new HashSet<>();
            int min = A[0];
            for(int i=1; i<A.length; i++) {
                min = Math.min(A[i], min);
                set.add(min);
            }
            result.add(set.size());
            
            
        }
        return result;
    }
}