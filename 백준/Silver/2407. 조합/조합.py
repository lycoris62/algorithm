n, m = map(int, input().split())
dp = [[1] * (n+1) for _ in range(n+1)]
for i in range(n+1):
    for j in range(m+1):
        if i == j:
            break
        elif 0 < j:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

print(dp[n][m])

"""
100 6

"""