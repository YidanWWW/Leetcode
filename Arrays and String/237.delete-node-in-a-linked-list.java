public class Solution {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        int count = 0;
        int consecutiveCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }

            count = (count + consecutiveCount) % MOD;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abbcccaa";
        System.out.println(solution.countHomogenous(s)); // 输出结果为 13
    }
}
