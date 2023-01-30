"""
    적록색약 (Gold 5)
    https://www.acmicpc.net/problem/10026
"""

from collections import deque

N = int(input())

board = [input() for _ in range(N)]
board_blind = [row.replace("R", "G") for row in board]
visit_o = [[False] * N for _ in range(N)]
visit_n = [[False] * N for _ in range(N)]
dxy = [(-1, 0), (1, 0), (0, 1), (0, -1)]
res = [0, 0]

def bfs_o(ox, oy, color, board, visit):
    q = deque()
    q.append((ox, oy))
    visit[ox][oy] = True

    while q:
        x, y = q.popleft()
        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy
            if (0 <= nx < N) and (0 <= ny < N) and (not visit[nx][ny]) and (board[nx][ny] == color):
                visit[nx][ny] = True
                q.append((nx, ny))

for i in range(N):
    for j in range(N):
        if not visit_o[i][j]:
            res[0] += 1
            bfs_o(i, j, board[i][j], board, visit_o)
        if not visit_n[i][j]:
            res[1] += 1
            bfs_o(i, j, board_blind[i][j], board_blind, visit_n)

print(*res)

"""
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

"""
