import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
    public static void main(String args[]) {
      List<Integer> list = new ArrayList<>();
      list.add(3); list.add(1); list.add(4); list.add(2);
      System.out.println(imbalance(list));
    }
    

    public static int imbalance(List<Integer> ranks){
        //1,5,4
        Set<Integer> set;
        int res = 0;
        for(int i=0; i<ranks.size(); i++) {
            set = new HashSet<>();
            set.add(ranks.get(i));
            int curImbalance=0;
            for(int j=i+1; j<ranks.size();j++) {
                int n = ranks.get(j);
                //1,5,4
                if(set.contains(n-1) && set.contains(n+1)) {
                    curImbalance--;
                }else if(!set.contains(n-1) && !set.contains(n+1)){
                    curImbalance++;
                }
                set.add(n);
                res += curImbalance;
            }
        }
        return res;

        
    }

}
