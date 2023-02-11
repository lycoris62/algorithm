"""
    가장 큰 정사각형 (Gold 4)
    https://www.acmicpc.net/problem/1915
"""

N, M = map(int, input().split())
arr = [ input() for _ in range(N)]
dp = [ [0] * M for _ in range(N)]

for j in range(M):
    if arr[0][j] == '1':
        dp[0][j] = 1

for i in range(1, N):
    if arr[i][0] == '1':
        dp[i][0] = 1
    for j in range(1, M):
        if arr[i][j] == '1':
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

ans = 0
for i in range(N):
    for j in range(M):
        ans = max(ans, dp[i][j])

print(ans ** 2)

"""
4 4
0100
0111
1110
0010

"""