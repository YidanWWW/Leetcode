// "static void main" must be defined in a public class.
public class Main {
    private static int get(int[] v, int x) {
        int r = 0;
        for (; x > 0; r += v[x], x -= lowbit(x))
        ;
        return r;
    }
    
    private static void update(int[] v, int x, int y) {
        for (; x < v.length; v[x] += y, x += lowbit(x))
        ;
    }
    
    private static int lowbit(int x) {
        return x & (-x);
    }
    
    public static int countKSpikes(int[] prices, int k) {
        Set<Integer> all = new TreeSet<>();
        all.addAll(Arrays.stream(prices).boxed().toList());
        int m = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : all) {
            map.put(x, ++m);
        }
        int[] v = new int[m + 1];
        final int n = prices.length;
        boolean[] ok = new boolean[n];
        
        int r = 0;
        for (int i = 0; i < n; ++i) {
            int x = map.get(prices[i]);
            ok[i] = get(v, x - 1) >= k;
            update(v, x, 1);
        }
        
        v = new int[m + 1];
        for (int i = n - 1; i >= 0; --i) {
            int x = map.get(prices[i]);
            r += ok[i] && get(v, x - 1) >= k ? 1 : 0;
            update(v, x, 1);
        }
        return r;
    }
    
    public static void main(String[] args) {
        System.out.println(countKSpikes(new int[]{1, 2, 8, 5, 3, 4}, 2));
        System.out.println(countKSpikes(new int[]{1,3,2,5,4}, 1));
        System.out.println(countKSpikes(new int[]{1,2,8,3, 7, 5,4}, 2));
        System.out.println(countKSpikes(new int[]{1,2,8,3, 7, 4, 6, 5}, 3));
        System.out.println(countKSpikes(new int[]{1, 1, 2, 3, 0, 0, 0}, 3));
        System.out.println(countKSpikes(new int[]{1, 2, 1, 8, 8, 5, 3, 4}, 2));
    }
}