package sf;
/*
 * Perfect Substring
A strings comprised of digits from 0 to 9 contains a perfect substring if all the elements within a substring occur exactly k times. Calci the number of perfect substrings in s.
Example
s = 1102021222
k= 2
The 6 perfect substrings are:
1. s[0:1] = 11
2. 5(0:5] = 110202
3. s[1:6] = 102021
4. 5[2:5] = 0202
5. s[7:8] = 22
6. 5[8:9] = 22
Function Description
Complete the function perfectSubstring in the editor below.
perfectSubstring has the following parameters:
str s. a string where the value of each element si is described by the character at position / (where 0 si < n)
int k. an integer that denotes the required frequency of the substring
Output
int: an integer that represents the number of perfect substrings in the given string
 */
import java.util.*;

public class perfectSubstring {

    public static int solution(String s, int k) {
        int n = s.length();
        int[][] p = new int[n + 1][10];
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                p[i][j] = p[i - 1][j];
            }
            p[i][s.charAt(i - 1) - '0']++;
        }
        
        int r = 0;
        for (int t = 1; t <= 10; ++t) {
            int len = t * k;
            if (len > n) {
                break;
            }
            int start = 0, end = 0;
            Map<Character, Integer> map = new HashMap<>();
            while(end<s.length()) {
                char e = s.charAt(end);
                map.put(e, map.getOrDefault(e,0)+1);
                if(len < end-start+1) {
                    char st = s.charAt(start);
                    map.put(st, map.get(st)-1);
                    if(map.get(st)==0) map.remove(st);
                    start++;
                }
                if(end-start+1==len) {
                    if(check(map, k)) r++;
                }
                end++;
            }
        }
        return r;
    }
    public static boolean check(Map<Character, Integer> count, int k) {
        for (int v : count.values()) {
            if (v != k && v != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("1102021222", 2));
    }
}
