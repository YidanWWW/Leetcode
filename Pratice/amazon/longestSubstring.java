package amazon;
import java.util.HashSet;
import java.util.Set;

public class MyClass {
    
    public static int LongestSubstring(String word, String[] strs){
        Set<String> set = new HashSet<>();
        for(String s:strs) set.add(s);
        int start = 0, end = 0, res = 0;
        while(end<word.length()) {
            while(set.contains(word.substring(start, end+1))) {
                start++;
            }
            res = Math.max(res, end-start+1);
            end++;
        }
        return res;

    }
    
    public static void main(String args[]) {
 
    String s1 = "abcd";
    String[] str = new String[]{"a","b"};
    System.out.println(LongestSubstring(s1, str));
    
    String s2 = "aaaa";
    String[] str2 = new String[]{"ab"};
    System.out.println(LongestSubstring(s2, str2));
    }
}