"""
    연결 요소의 개수 (Silver 2)
    https://www.acmicpc.net/problem/11724
"""

from collections import deque
import sys
sys.setrecursionlimit(10 ** 7) # 재귀 호출 제한 올리기
input = sys.stdin.readline # 많은 입력을 받아 시간 초과가 나므로 이렇게 입력 받기.

n, m = map(int, input().split()) # 정점과 간선 입력
adj = [[0] * n for _ in range(n)] # 인접 행렬 생성
q = deque() # bfs 용 큐
check = [False] * n # 방문한 정점 체크용
count = 0 # 연결 요소 개수

for _ in range(m): # 간선 개수만큼 입력을 받는데 1부터 시작이므로 -1 해서 저장.
    u, v = map(lambda x: x - 1, map(int, input().split()))
    adj[u][v] = adj[v][u] = 1 # 무방향이므로 대각 행렬로 만들어줌

def bfs(y): # bfs 용으로, 정점을 받아 정점에서 다른 정점으로 가는 요소들 체크
    q.append(y)
    while q:
        now = q.popleft() # 출발 정점 뽑아서
        check[now] = True # 출발 정점은 이미 방문했다고 체크 한 후에
        for nxt in range(n): # 출발(now) => 도착(nxt) 정점들 중 방문 안 한 곳으로 돌면서 체크
            if adj[now][nxt] and not check[nxt]:
                q.append(nxt)
                # adj[now][nxt] = False

def dfs(now): # dfs 로 구현.
    for nxt in range(n): # 출발(now) => 도착(nxt) 장점들 중 방문 안 한 곳으로 돌면서 체크
        if adj[now][nxt] and not check[nxt]:
            check[nxt] = True
            dfs(nxt)

for i in range(n):
    if not check[i]:
        count += 1
        check[i] = True
        dfs(i) # bfs는 시간초과 나네.. 

print(count)

"""
6 5
1 2
2 5
5 1
3 4
4 6

6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3

"""
