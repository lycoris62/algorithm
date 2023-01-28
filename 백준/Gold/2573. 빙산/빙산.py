"""
    빙산 (Gold 4)
    https://www.acmicpc.net/problem/2573
"""

import copy
from collections import deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dd = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(ox, oy):
    q = deque()
    q.append((ox, oy))
    visited[ox][oy] = 1
    seaList=[]

    while q:
        x, y = q.popleft()
        sea = 0
        for dx, dy in dd:
            nx = x + dx
            ny = y + dy
            if (0 <= nx < N) and (0 <= ny < M):
                if (not board[nx][ny]):
                    sea += 1
                elif (board[nx][ny]) and not visited[nx][ny]:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
        if sea > 0:
            seaList.append((x, y, sea))
    for x, y, sea in seaList:
        board[x][y] = max(0, board[x][y] - sea)
    return 1

ice = []
for i in range(N):
    for j in range(M):
        if board[i][j]:
            ice.append((i, j))

year = 0

while ice:
    visited = [ [0] * M for _ in range(N)]
    delList = []
    group = 0
    for i, j in ice:
        if board[i][j] and not visited[i][j]:
            group += bfs(i, j)
        if board[i][j] == 0:
            delList.append((i, j))
    if group > 1:
        print(year)
        break
    ice = sorted(list(set(ice) - set(delList)))
    year += 1

if group < 2:
    print(0)

"""
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0

3 3
1 0 1
0 1 0
1 0 1

"""
