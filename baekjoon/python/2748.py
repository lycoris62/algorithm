"""
    피보나치 수 2 (Bronze 1)
    https://www.acmicpc.net/problem/2748
"""

n = int(input())

cache = [-1] * 91 # n이 최대 90이므로, 0~90까지 91개의 공간 필요.
cache[0] = 0 # 피보나치 수의 F0은 0
cache[1] = 1 # 피보나치 수의 F1은 1

def fi_bottomup(n): # Tabulation, 순서 중요
    for i in range(2, n + 1): # 0, 1은 미리 초기화 해뒀으므로 2부터 n까지 반복문을 돌림.
        cache[i] = cache[i - 1] + cache[i - 2]
    return cache[n]

def fi_topdown(n): # Memoization
    if cache[n] == -1: # 초기값인 경우
        cache[n] = cache[n-1] + cache[n-2]
    return cache[n]


print(fi_bottomup(n))
# print(fi_topdown(n))

"""
10

"""