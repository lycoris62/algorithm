class Solution {
    public long solution(int n) {
        // DP
        // 특정 칸에 도달하는 경우의 수는, 그 칸의 1칸 전 경우의 수 + 2칸 전 경우의 수
        // y(x) = y(x-1) + y(x-2)
        // 초기값은 y(1) = 1, y(2) = 2 (2, 1+1)
        
        int[] dp = new int[Math.max(2, n) + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1234567;
        }
        
        return dp[n];
    }
}