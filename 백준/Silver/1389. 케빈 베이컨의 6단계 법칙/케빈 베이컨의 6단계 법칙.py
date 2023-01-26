"""
    케빈 베이컨의 6단계 법칙 (Silver 1)
    https://www.acmicpc.net/problem/1389
"""

import sys
from collections import deque

N, M = map(int, input().split())

adj = [[] for _ in range(N)]

for _ in range(M):
    a, b = map(lambda x: x - 1, map(int, input().split()))
    adj[a].append(b)
    adj[b].append(a)

kevin = []
ans = (-1, sys.maxsize)

def bfs(start, goal):
    chk = [False] * N
    chk[start] = True
    dq = deque()
    dq.append((start, 0))
    while dq:
        now, d = dq.popleft()
        if now == goal:
            return d

        nd = d + 1
        for nxt in adj[now]:
            if not chk[nxt]:
                chk[nxt] = True
                dq.append((nxt, nd))

def get_kevin(start):
    tot = 0
    for i in range(N):
        if i != start:
            tot += bfs(start, i)
    return tot

for i in range(N):
    kevin.append(get_kevin(i))

for i, v in enumerate(kevin):
    if ans[1] > v:
        ans = (i, v)

print(ans[0] + 1)

# 틀린 답. 
# import sys
# N, M = map(int, input().split())
#
# arr = [ [sys.maxsize] * N for _ in range(N)]
#
# for _ in range(N):
#     a, b = map(lambda x:x-1, map(int, input().split()))
#     arr[a][b] = 1
#     arr[b][a] = 1
#
# for mid in range(N):
#     for start in range(N):
#         for end in range(N):
#             if start == end:
#                 arr[start][end] = 0
#             else:
#                 arr[start][end] = min(arr[start][end], arr[start][mid] + arr[mid][end])
#
# result = []
# for row in arr:
#     result.append(sum(row))
#
# print(result.index(min(result)) + 1)

"""
5 5
1 3
1 4
4 5
4 3
3 2

"""
