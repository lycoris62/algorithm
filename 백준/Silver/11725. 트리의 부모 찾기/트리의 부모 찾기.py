import sys
from collections import deque

N = int(input())
graph = [[] for _ in range(N)]
for _ in range(N-1):
    a, b = map(lambda x:x-1, map(int, sys.stdin.readline().rstrip().split()))
    graph[a].append(b)
    graph[b].append(a)

res = [-1] * N

def bfs():
    q = deque()
    q.append(0)
    while q:
        now = q.popleft()
        for nxt in graph[now]:
            if res[nxt] == -1:
                res[nxt] = now
                q.append(nxt)

bfs()

for x in res[1:]:
    print(x+1)

"""
7
1 6
6 3
3 5
4 1
2 4
4 7

12
1 2
1 3
2 4
3 5
3 6
4 7
4 8
5 9
5 10
6 11
6 12

"""