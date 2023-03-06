N = int(input())
li = list(map(int, input().split()))

dp = [0 for _ in range(N)]

for i in range(N):
    for j in range(i):
        if li[j] < li[i] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1

print(max(dp))

"""
6
10 20 10 30 20 50

"""
