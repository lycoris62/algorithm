"""
    말이 되고픈 원숭이 (Gold 3)
    https://www.acmicpc.net/problem/1600
"""

from collections import deque

k = int(input())
W, H = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(H)]
check = [[[0] * (k + 1) for _ in range(W)] for _ in range(H)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
dxx = [1,2,1,2,-1,-2,-1,-2]
dyy = [2,1,-2,-1,2,1,-2,-1]

def bfs():
    q = deque()
    q.append((0, 0, 0))
    check[0][0][0] = 1

    while q:
        n, m, k_cnt = q.popleft()
        if n == H - 1 and m == W - 1:
            return check[n][m][k_cnt] - 1

        for i in range(4):
            nn = n + dx[i]
            nm = m + dy[i]
            if (0 <= nn < H) and (0 <= nm < W) and board[nn][nm] != 1 and not check[nn][nm][k_cnt]:
                check[nn][nm][k_cnt] = check[n][m][k_cnt] + 1
                q.append((nn, nm, k_cnt))
        if k_cnt < k:
            for i in range(8):
                nn = n + dxx[i]
                nm = m + dyy[i]
                if (0 <= nn < H) and (0 <= nm < W) and board[nn][nm] != 1 and not check[nn][nm][k_cnt + 1]:
                    check[nn][nm][k_cnt + 1] = check[n][m][k_cnt] + 1
                    q.append((nn, nm, k_cnt + 1))
    return -1
print(bfs())

"""
1
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0

2
5 2
0 0 1 1 0
0 0 1 1 0

"""