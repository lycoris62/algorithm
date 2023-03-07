"""
    2×n 타일링 (Silver 3)
    https://www.acmicpc.net/problem/11726
"""

n = int(input())
MOD = 10007

dp = [0] * 1001 # n의 범위가 1부터 1000까지이므로 1001개 배열 생성 (dp)
dp[1] = 1 # n=1의 값 초기화
dp[2] = 2 # n=2의 값 초기화

def dp_bottomup(n): # bottomup 방식으로 구현
    for i in range(3, 1001):
       dp[i] = (dp[i-1] + dp[i-2]) % MOD
    return dp[n]

def dp_topdown(n): # topdown 방식으로 구현
    if dp[n] == 0:
        dp[n] = (dp[n-1] + dp[n-2]) % MOD
    return dp[n]

print(dp_bottomup(n))
# print(dp_topdown(n))

"""
2

9

"""