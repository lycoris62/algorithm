from collections import deque
import sys

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def bfs():
    while q:
        x, y = q.popleft()
        now_state = visited[x][y] # 현재 좌표의 상태를 저장. 불이라면 FIRE, 상근이면 이동횟수가 저장됨. 

        for i in range(4): # 상하좌우 돌기 
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < h and 0 <= ny < w: # 좌표 범위 안이고,
                # 아직 방문하지 않았고, 빈 곳이거나 상근이 시작점이라면, 
                if visited[nx][ny] == -1 and (board[nx][ny] == "." or board[nx][ny] == "@"):
                    if now_state == "FIRE": # 현재 상태가 불이라면 인근 상하좌우도 불이 붙음 
                        visited[nx][ny] = now_state
                    else: # 현재 상태가 상근이의 이동횟수라면 횟수를 1 올려서 저장 
                        visited[nx][ny] = now_state + 1
                    q.append((nx, ny)) # 큐에 인근 좌표값 저장 
            else: # 좌표 범위를 벗어났고, 상근이라면 탈출했다는 뜻이므로 탈출 1칸을 더해 이동 횟수 리턴
                if visited[x][y] != "FIRE":
                    return visited[x][y] + 1

    return "IMPOSSIBLE" # 상근이가 탈출하지 못했으므로 IMPOSSIBLE 리턴 


t = int(input()) # 테스트 케이스 입력 

for _ in range(t): # 테스트 케이스 돌리기 
    w, h = map(int, input().split())
    q = deque() # BFS 큐용 
    board = [] # 입력 좌표 받기용 
    visited = [[-1] * w for _ in range(h)] # 방문한 좌표 표시를 위한 2차원 배열, 아직 안 간 곳은 -1
    
    for i in range(h):
        board.append(list(input().strip())) # 각 줄을 입력으로 받고, 문자 단위로 배열로 넣기 
        for j in range(w): # 받은 배열중 상근이와 불의 시작점을 BFS 큐에 넣기 
            if board[i][j] == "@": # 상근이 시작점이면 방문 표시 및 큐 시작점으로 저장 
                visited[i][j] = 0
                start = (i, j) # 불이 먼저 퍼져야 하므로 큐에 아직 넣지 않음 
            elif board[i][j] == "*": # 불의 시작점이면 visited에 불이라고 표시 후 큐에 넣기 
                visited[i][j] = "FIRE"
                q.append((i, j))

    q.append(start) # 상근이를 큐의 가장 마지막에 넣은 후 
    print(bfs()) # BFS 시작 
