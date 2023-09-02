package amazon;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int splitString(String s, int k) {
        //Split into two strings so that the number of distinct chars in both substrs > k, 
        //how many ways are there
        int[] pre = new int[s.length()+1];
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
            pre[i+1] = set.size();
        }
        
        set.clear();
        int[] suf = new int[s.length()+1];
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            set.add(c);
            
            suf[i]= set.size();
        }
        int res = 0;
        
        
        for(int i=0; i<=s.length(); i++) {
            if(pre[i]>k && suf[i]>k) res++;
        }
        return res;
        
    }
    

    public static void main(String[] args) {
        String s = "adbccdbada";
        int k = 4;
        //int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(splitString(s, 2));
    }
}