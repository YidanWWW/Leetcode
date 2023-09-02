package sf;
import java.util.*;
/*
 *  Better compression
Given a string , return the compressed version of string

Eg : input : a3c9b2c1
output : a3c10b2
Since c occurs 2 times it needs to compressed like this.

Eg : input :a12c4b2a1
output : a13c4b2

Note count can be 2 digits also (more than 1 digit)
Also order of the characters needs to be maintained.
 */
public class StringCompression {
    public static String compressString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        char cur = s.charAt(0);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                cur = c;
            }else {
                int count = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    count = count*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                map.put(cur, map.getOrDefault(cur, 0)+count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:map.keySet()) {
            sb.append(c);
            sb.append(map.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "a3c9b2c1";
        String input2 = "a12c4b2a1";

        String output1 = compressString(input1);
        String output2 = compressString(input2);

        System.out.println(output1);  // Output: a3c10b2
        System.out.println(output2);  // Output: a13c4b2
    }
}



//按照字母顺序排序
    public static String fish(String s) {
        int[] fre = new int[26];
        char cur = s.charAt(0);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                cur = c;
            }else {
                int count = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    count = count*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                fre[cur-'a'] += count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(fre[i]>0) {
                sb.append((char)('a'+i));
                sb.append(fre[i]);
            }
        }
        return sb.toString();
    }

   
