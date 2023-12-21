class Solution {
    
    private final long OP = 1_234_567;
    private long[] dp;
    
    public long solution(int n) {
        long answer = 0;
        
        dp = new long[n + 1];
        dp[0] = dp[1] = 1L;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= OP;
        }
        
        return dp[n];
    }
}