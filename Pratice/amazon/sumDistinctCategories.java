package amazon;
import java.util.HashMap;

public class MyClass {

    public static long sumDistinctCategories(int[] v) {
        int n = v.length;
        HashMap<Integer, Integer> last = new HashMap<>();//value is index
        long r = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            if (last.containsKey(v[i])) {
                sum += i - last.get(v[i]);
            } else {
                sum += i + 1;
            }
            last.put(v[i], i);
            r += sum;
        }

        return r;
    }

    public static void main(String[] args) {
        int[] v = {1, 5, 1, 3};
        System.out.println(sumDistinctCategories(v));
    }
}

