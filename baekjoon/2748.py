"""
    피보나치 수 2
    https://www.acmicpc.net/problem/2748
"""

n = int(input())

cache = [-1] * 91
cache[0] = 0
cache[1] = 1

def fi_bottomup(n): # Tabulation, 순서 중요
    for i in range(2, n + 1):
        cache[i] = cache[i - 1] + cache[i - 2]
    return cache[n]

def fi_topdown(n): # Memoization
    if cache[n] == -1:
        cache[n] = cache[n-1] + cache[n-2]
    return cache[n]


print(fi_bottomup(n))

"""
10

"""