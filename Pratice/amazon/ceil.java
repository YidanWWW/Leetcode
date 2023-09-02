package amazon;
import java.util.HashMap;

import java.util.HashMap;

public class Main {

    //[4333]==>7, [584482]==>20
    public static void main(String[] args) {
        int res = 0;
        int[] execution = {5, 8, 4, 4 ,8, 2};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : execution) {
            if (!map.containsKey(i)) {
                map.put(i, i);
            } else {
                int oldValue = map.get(i);
                int newValue = oldValue / 2 + (oldValue / 2 * 2 != oldValue ? 1 : 0);
                map.put(i, newValue);
            }
            res += map.get(i);
        }

        System.out.println(res);
    }
}
