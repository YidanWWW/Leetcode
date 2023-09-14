package TwoSigma;
import java.util.*;

public class findSubstring {
    static List<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();
    public static List<String> solution(String s) {
        char[] chars = s.toCharArray();
        //dfs(chars, 0);
        int len = s.length(); //abc
        for(int i=0; i<len; i++) {
            for(int j=i+2; j<=len; j++) {
                String sub = s.substring(i, j);
                if(isVowel(sub.charAt(0)) && !isVowel(sub.charAt(sub.length()-1))) {
                    res.add(sub);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    // public static void dfs(char[] chars, int start) {
    //     if(path.length()>1 && !isVowel(path.charAt(path.length()-1)) && isVowel(path.charAt(0))) {
    //         res.add(path.toString());
    //         //return;      
    //     }
    //     for(int i=start; i<chars.length;i++) {
    //         path.append(chars[i]);
    //         dfs(chars, i+1);
    //         path.deleteCharAt(path.length()-1);
    //     }
        
    // }
    public static boolean isVowel(char c) {
        if(c=='a'||c=='e' || c=='i' || c=='o' || c=='u') {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        List<String> missingWordsList = solution(s);

        for (String word : missingWordsList) {
            System.out.print(word + " ");
        }
    }
    //aa  bc -> ab, aab, ac, aac, abc, aabc, 
}

