"""
    이항 계수 2
    https://www.acmicpc.net/problem/11051
"""

import sys
sys.setrecursionlimit(10 ** 7)
n, k = map(int, input().split())
MOD = 10007

cache = [[0] * 1001 for _ in range(1001)]

def bino_topdown(n, k):
    if cache[n][k]:
        return cache[n][k]

    if k == 0 or k == n:
        cache[n][k] = 1
    else:
        cache[n][k] = bino_topdown(n - 1, k - 1) + bino_topdown(n - 1, k)
        cache[n][k] %= MOD

    return cache[n][k]

def bino_bottomup(n, k):
    for i in range(1001):
        cache[i][0] = cache[i][i] = 1
        for j in range(1, i):
            cache[i][j] = cache[i-1][j-1] + cache[i-1][j]
            cache[i][j] %= MOD

    return cache[n][k]

print(bino_bottomup(n, k))

"""
# 재귀 
def bino(n, k):
    if k == 0 or k == n:
        return 1
    return bino(n-1, k-1) + bino(n-1, k)
"""

