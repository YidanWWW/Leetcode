package sf;

public class subsequenceCount {
    public static int numDistinct(String t, String s) {
        int m = s.length(), n = t.length();
        //if(n>m) return -1;
        long[][] dp = new long[m + 1][n + 1];
        // initialize the dp value when t is an empty string, number of subsequence of an empty string should be 1
        for(int i = 0; i <= m; i ++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if(dp[m][n]>Integer.MAX_VALUE) return -1;
        return (int)dp[m][n];

    }

    public static void main(String[] args) {

        System.out.println(numDistinct("ABC", "ABCBABC"));  // Output: a3c10b2
        //System.out.println(output2);  // Output: a13c4b2
    }
}
