package Pratice;
public class Solution {
    public static String isSubStr(String np, String op) {
        int[] arr = new int[26];
        for(char c: op.toCharArray()) arr[c-'a']++;
        int p1 = 0, p2 = 0;
        while(p1<np.length() || p2<op.length()) {
            char c1 = np.charAt(p1);
            char c2 = op.charAt(p2);
            if((char)(c1+1) ==c2 || (char)(c1-1)==c2 || c1==c2) {
                p1++;
                p2++;
            }else {
                p1++;
            }
        }
        if(p2==op.length()) return "YES";
        return "NO";
    }
    

    public static void main(String[] args) {
        String s1 = "baacbab";
        String s2 = "abdbc";
        int k = 4;
        //int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(isSubStr(s1, s2));
    }
}
