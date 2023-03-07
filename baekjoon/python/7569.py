import sys
from collections import deque

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs():
    while queue:
        now_x, now_y, now_z = queue.popleft()

        for i in range(6):
            search_x = now_x + dx[i]
            search_y = now_y + dy[i]
            search_z = now_z + dz[i]

            if ( 0 <= search_x < h ) and ( 0 <= search_y < n ) and ( 0 <= search_z < m ) and ( graph[search_x][search_y][search_z] == 0 ):
                queue.append([search_x, search_y, search_z])
                graph[search_x][search_y][search_z] = graph[now_x][now_y][now_z] + 1

m, n, h = map(int, sys.stdin.readline().split())
graph = deque([])
queue = deque([])

for i in range(h):
    temp = []
    for j in range(n):
        temp.append(list(map(int, sys.stdin.readline().split())))
        for k in range(m):
            if temp[j][k] == 1:
                queue.append([i, j, k])
    graph.append(temp)

bfs()

day = 0
for i in graph:
    for j in i:
        for k in j:
            if k==0:
                print(-1)
                exit(0)
        day = max(day,max(j))
print(graph)
print(day-1)
