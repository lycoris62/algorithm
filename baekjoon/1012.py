from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

T = int(input())

def BFS(graph, a, b):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if ( 0 <= nx < n and 0 <= ny < m ):
                if graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    queue.append((nx, ny))
    return

for t in range(T):
    cnt = 0
    n, m, K = map(int, input().split())
    graph = [ [0] * m for _ in range(n) ]

    for k in range(K):
        x, y = map(int, input().split())
        graph[x][y] = 1

    for a in range(n):
        for b in range(m):
            if graph[a][b] == 1:
                BFS(graph, a, b)
                cnt += 1
    print(cnt)
