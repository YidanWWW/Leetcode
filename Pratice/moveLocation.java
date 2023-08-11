package Pratice;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    //3 list, change location from moveFrom to moveTo
   public static int[] moveLocation(int[] location, int[] moveFrom, int[] moveTo) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<moveFrom.length; i++) {
            map.put(moveFrom[i], moveTo[i]);
        }
        int[] res = new int[location.length];
        for(int i=0; i<res.length; i++) {
            if(map.containsKey(location[i])) {
                res[i] = map.get(location[i]);
            }else {
                res[i] = location[i];
            }
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 7, 6, 8};
        int[] a2 = new int[]{1, 7, 2};
        int[] a3 = new int[]{2, 9, 5};
        int[] result = moveLocation(a1, a2, a3);
        System.out.println(Arrays.toString(result));
        
    }
}
