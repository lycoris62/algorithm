import sys
from collections import deque
from itertools import permutations

board = [ [ list(map(int, input().split(' '))) for _ in range(5) ] for _ in range(5) ]
b = [ [ [0] * 5 for _ in range(5) ] for _ in range(5) ]
res = sys.maxsize

dh = (0, 0, 0, 0, 1, -1)
dy = (0, 0, 1, -1, 0, 0)
dx = (1, -1, 0, 0, 0, 0)

def solve():
    for d in permutations([0,1,2,3,4]):
        for i in range(5):
            b[d[i]] = board[i]
        dfs(0)

def rotate(b):
    temp = [ [0] * 5 for _ in range(5) ]
    for i in range(len(b)):
        for j in range(len(b[0])):
            temp[j][4-i] = b[i][j]
    return temp

def dfs(d):
    if d == 5:
        if b[4][4][4]:
            bfs(b)
        return
    for i in range(4):
        if b[0][0][0]:
            dfs(d + 1)
        b[d] = rotate(b[d])

def bfs(b):
    q = deque()
    dist = [ [ [0,0,0,0,0] for _ in range(5) ] for _ in range(5) ]
    q.append((0, 0, 0))

    while q:
        global res
        h, y, x = q.popleft()
        if (h, y, x) == (4,4,4):
            res = min(res, dist[4][4][4])
            if res == 12:
                print(res)
                exit()
            return
        for i in range(6):
            nh = h + dh[i]
            ny = y + dy[i]
            nx = x + dx[i]

            if not (0 <= nh < 5 and 0 <= ny < 5 and 0 <= nx < 5):
                continue
            elif b[nh][ny][nx] == 0 or dist[nh][ny][nx] != 0:
                continue
            q.append((nh, ny, nx))
            dist[nh][ny][nx] = dist[h][y][x] + 1
solve()

if res == sys.maxsize:
    res = -1
print(res)
