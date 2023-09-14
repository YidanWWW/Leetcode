package sf;
import java.util.*;

public class optimize {
    public static void go(int[] arr, int k) {
        int n = arr.length;
        for(int i=0; i<k; i++) {
            arr[i%n] ^= arr[n-1-(i%n)];
        }
    }
    public static void solution(int[] arr, int k) {
        int n = arr.length;
        if(k<n) {
            go(arr, k);
        }else {
            k %= (n*3);
            go(arr, k);
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    
    public static void main(String args[]) {
        int[] v = {5,6,7,8,9}; 
        int k = 26; 
        solution(v, k);
    }
}
