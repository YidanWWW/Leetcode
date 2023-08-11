package Pratice;
public class Solution {
   public static int countMaximumOperations(String s1, String s2) {
        int[] arr1=new int[26];
        for(char c:s1.toCharArray()) arr1[c-'a']++;
        int[] arr2 = new int[26];
        for(char c:s2.toCharArray()) arr2[c-'a']++;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            if(arr2[i]!=0) res = Math.min(res, arr1[i]/arr2[i]);
        }
        return res;
        
    }

    public static void main(String[] args) {
        String s1 = "momonom";
        String s2 = "mon";
        String s3 = "abacbc";
        String s4 = "bca";
        System.out.println(countMaximumOperations(s1, s2));
        System.out.println(countMaximumOperations(s3, s4));
        
    }
}
