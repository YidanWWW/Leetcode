
public class Solution {
    //lexicographically smallest palindrome
    public static String smallestPalindrome(String s) {
        //bacab->abcba. aabbc
        int n = s.length();
        String str = s.substring(0, n/2+1);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] res = new char[n];
        int start = 0, end = n-1;
        while(start<=end) {
            res[start] = chars[start];
            res[end] = chars[start];
            start++;
            end--;
        }
        if(n%2==1) res[n/2] = chars[n/2];
        return new String(res);
        
    }
    

    public static void main(String[] args) {
        String s1 = "dfsaasfd";
        //String s2 = "abdbc";
        int k = 4;
        //int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(smallestPalindrome(s1));
    }
}

