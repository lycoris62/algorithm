"""
    이항 계수 2 (Silver 2)
    https://www.acmicpc.net/problem/11051
"""

# 파이썬에서는 재귀 최대 한도의 디폴트가 1000이기 때문에 더 늘려주려면 다음의 코드가 필요
import sys
sys.setrecursionlimit(10 ** 7)

n, k = map(int, input().split())
MOD = 10007

cache = [[0] * 1001 for _ in range(1001)] # N, K는 1부터 1000까지 이므로 이중 배열 생성

# 이항계수 nCk를 bino(n, k) 라 하면,
# bino(n, k) = bino(n-1, k-1) + bino(n-1, k) 로 구현 가능하다.

def bino_topdown(n, k): # 탑다운 방식으로 구현
    if cache[n][k]: # cache가 0 값이 아니면(=이미 계산되어 저장된 값이면) 그 값을 리턴.
        return cache[n][k]

    if k == 0 or k == n: # k가 0이거나 n과 같으면 무조건 1이므로 cache에 저장.
        cache[n][k] = 1
    else: # 나머지 경우에는 dp 재귀 적용.
        cache[n][k] = bino_topdown(n - 1, k - 1) + bino_topdown(n - 1, k)
        cache[n][k] %= MOD

    return cache[n][k]

def bino_bottomup(n, k): # 바텀업 방식으로 구현
    for N in range(1001): # N이 0부터 1000까지 반복문을 돌려서 전부 계산함
        cache[N][0] = cache[N][N] = 1 # k가 0이거나 n과 같으면 1로 저장.
        for K in range(1, N): # K가 1부터 N-1 까지는 dp로 적용.
            cache[N][K] = cache[N-1][K-1] + cache[N-1][K]
            cache[N][K] %= MOD

    return cache[n][k]

print(bino_bottomup(n, k))
# print(bino_topdown(n, k))

"""
# 재귀로 풀 경우. n, k가 커질수록 오래 걸림. 
def bino(n, k):
    if k == 0 or k == n:
        return 1
    return bino(n-1, k-1) + bino(n-1, k)
"""

"""
5 2

"""