"""
    미로 탐색 (Silver 1)
    https://www.acmicpc.net/problem/2178
"""

from collections import deque

N, M = map(int, input().split()) # N 행 M 열 입력 받기
adj = [list(map(int, input())) for _ in range(N)] # 미로 행렬 저장
visited = [[False] * M for _ in range(N)] # 미로 방문 행렬 저장
q = deque() # bfs용 큐
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(y, x):
    q.append((y, x))
    visited[y][x] = True
    while q:
        oy, ox = q.popleft()
        for i in range(4):
            ny = oy + dy[i]
            nx = ox + dx[i]
            if (0 <= ny < N and 0 <= nx < M) and adj[ny][nx] !=0 and not visited[ny][nx]:
                q.append((ny, nx))
                visited[ny][nx] = True
                adj[ny][nx] = adj[oy][ox] + 1 # 미로 행렬의 값이 곧 최단 거리
bfs(0, 0)

# for _ in range(N):
#     print(adj[_])
# for _ in range(N):
#     print(visited[_])

print(adj[N-1][M-1]) # 무조건 길은 있다고 했으니 N행 M열 값을 출력

"""
4 6
101111
101010
101011
111011

4 6
110110
110110
111111
111101

2 25
1011101110111011101110111
1110111011101110111011101

7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111

"""