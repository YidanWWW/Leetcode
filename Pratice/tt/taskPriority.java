import java.util.*;


public class Main {
    public static long solution(int[] p, int x, int y) {
        int[] v = Arrays.copyOf(p, p.length);
        Arrays.sort(v);
        long sum = 0;
        for (int i = 1; i <= v.length && i <= x; ++i) {
            sum += v[v.length - i];
        }
        long r = sum * (y / x);
        for (int i = Math.min(y % x, v.length); i > 0; --i) {
            r += v[v.length - i];
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5, 7));
        System.out.println(solution(new int[]{2, 1, 3}, 2, 3));
        System.out.println(solution(new int[]{1}, 3, 10));
    }
}