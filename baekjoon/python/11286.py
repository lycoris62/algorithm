"""
    11286 절댓값 힙
    https://www.acmicpc.net/problem/11286
"""

import heapq
import sys

input = sys.stdin.readline

n = int(input())
pq = [] # 우선순위 힙

for _ in range(n):
    x = int(input())
    if x == 0: # 0을 입력 받으면
        # 힙이 비어있으면 0을 출력, 아니면 최소 절댓값 중에서 최솟값 출력
        print(heapq.heappop(pq)[1] if pq else 0)
    else:
        # (절댓값, 원래값) 튜플로 넣어서 절댓값으로 1차 비교 후 원래값 중 최솟값으로 비교하도록 함
        heapq.heappush(pq, (abs(x), x))

"""
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0

"""