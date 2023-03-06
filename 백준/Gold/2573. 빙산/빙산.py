"""
    빙산 (Gold 4)
    https://www.acmicpc.net/problem/2573
"""

from collections import deque

N, M = map(int, input().split()) # N * M 배열
board = [list(map(int, input().split())) for _ in range(N)]
dd = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs(ox, oy):
    q = deque()
    q.append((ox, oy))
    visited[ox][oy] = 1 # 현재 좌표 방문 체크
    seaList=[] # 상하좌우에 바다가 있을 때 현재 좌표와 바다 개수를 요소로 갖는 리스트

    while q:
        x, y = q.popleft()
        sea = 0 # 인근 상하좌우의 바다 개수
        for dx, dy in dd:
            nx = x + dx
            ny = y + dy
            if (0 <= nx < N) and (0 <= ny < M): # 인근 좌표가 범위 안이고,
                if (not board[nx][ny]): # 그 좌푯값이 0이면 (바다이면)
                    sea += 1 # 바다 개수 +1
                elif (board[nx][ny]) and not visited[nx][ny]: # 0이 아니고(빙산이고) 방문하지 않았으면,
                    visited[nx][ny] = 1 # 방문 체크
                    q.append((nx, ny)) # 큐에 넣기.

        if sea > 0: # 상하좌우에 바다가 있다면, 빙산 높이 처리를 위해 따로 보관
            seaList.append((x, y, sea))

    for x, y, sea in seaList: # 바다와 인접해 있다면 개수만큼 빙산이 녹지만 0밑으로는 내려가지 못함
        board[x][y] = max(0, board[x][y] - sea)

    return 1

ice = [] # 방산 좌표 리스트
for i in range(N):
    for j in range(M):
        if board[i][j]: # 빙산이라면 (바다가 아니라면)
            ice.append((i, j)) # 빙산 좌표를 입력

year = 0 # 방산이 녹는데 걸리는 세월

while ice: # 빙산이 있다면,
    visited = [ [0] * M for _ in range(N)] # 방문 체크
    delList = [] # 삭제해야할 것들을 모아놓는 리스트
    group = 0 # 빙산 덩어리 수
    for i, j in ice: # 빙산 좌표를 가져와서
        # bfs 돌면서 0이 됐을 수도 있으니 바다가 아니고 방문 안 했는지 체크
        if board[i][j] and not visited[i][j]:
            group += bfs(i, j) # bfs 한바퀴가 한 덩어리라는 뜻이므로 +1
        if board[i][j] == 0: # ice 반복문을 도는 중 ice를 수정하면 에러나므로 따로 넣어줌
            delList.append((i, j))
    if group > 1: # 두 덩어리로 분리되면
        print(year) # 정답 출력후 종료
        break
    # 바다가 되어버린 ice 제거 후 다시 반복문 돌림
    ice = sorted(list(set(ice) - set(delList)))
    year += 1 # 한 세월 흐름

if group < 2: # 빙산이 다 녹아도 분리되지 않으면 0 출력
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

3 3
0 0 0
0 3 0
0 0 0

"""
