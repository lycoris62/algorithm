import java.util.*;

class Solution {
    
    int[] dp;
    final int OP = 1_234_567;
    
    public int solution(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= OP;
        }
        
        return dp[n];
    }
}