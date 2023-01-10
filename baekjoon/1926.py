from collections import deque
import sys

n, m = map(int, input().split())

arr = deque()
q = deque()
draw_num = 0 # 그림 개수 
max_area = 0 # 그림이 하나도 없는 경우에 가장 넓은 그림의 넓이는 0 이므로 

for _ in range(n):
    arr.append(list(map(int, input().split())))

dx = (0, 0, -1, 1)
dy = (-1, 1, 0, 0)

def bfs(ox, oy):
    seq = 1 # 그림 넓이를 구하기 위한 변수 
    q.append((ox, oy))
    arr[ox][oy] = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0<=nx<n) and (0<=ny<m) and (arr[nx][ny] == 1):
                q.append((nx, ny))
                arr[nx][ny] = 0
                seq += 1
    return seq

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            draw_num += 1 # 그림 개수 1개 올림 
            bfs_area = bfs(i, j) # bfs로 구한 그림의 넓이를 저장 
            max_area = max(bfs_area, max_area) # 지금까지 가장 넓은 그림 넓이와 현재 넓이 비교 

print(draw_num) # 그림 개수 출력 
print(max_area) # 최대 그림 넓이 출력 
