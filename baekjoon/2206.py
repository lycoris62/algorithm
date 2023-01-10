from collections import deque

n, m = map(int, input().split())

graph = []
visited = [ [ [0, 0] for _ in range(m) ] for _ in range(n) ]
visited[0][0][0] = 1

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for _ in range(n):
    graph.append(list(map(int, input())))

def bfs(x, y, z):
    q = deque()
    q.append((x, y, z))

    while q:
        sx, sy, crash = q.popleft()
        
        if sx == (n-1) and sy == (m-1):
            return visited[sx][sy][crash]
        
        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if not (0<=nx<n and 0<=ny<m):
                continue
            if graph[nx][ny] == 1 and crash == 0:
                visited[nx][ny][1] = visited[sx][sy][0] + 1
                q.append((nx, ny, 1))
            elif graph[nx][ny] == 0 and visited[nx][ny][crash] == 0:
                visited[nx][ny][crash] = visited[sx][sy][crash] + 1
                q.append((nx, ny, crash))
    return -1

print(bfs(0, 0, 0))
