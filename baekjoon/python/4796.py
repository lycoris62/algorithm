"""
    캠핑 (Bronze 1)
    https://www.acmicpc.net/problem/4796
"""

import sys
input = sys.stdin.readline # 입력이 많을 수 있으니 이러케.
case = 1 # Case가 1부터 시작하므로 1로 초기화.

while True:
    L, P, V = map(int, input().split())
    if L == 0 and P == 0 and V == 0: # 1 < L < P < V 이므로 L == 0 만 해도 되긴 함.
        break # 종료.

    res = (V // P) * L + min(V % P, L) # P 단위만큼은  L개가 확정, 나머지와 L 중에 최솟값을 더함

    print(f"Case {case}: {res}")
    case += 1

"""
5 8 20
5 8 17
0 0 0

"""
