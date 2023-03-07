"""
    숨바꼭질 (Silver 1)
    https://www.acmicpc.net/problem/1697
"""

from collections import deque

MAX_NUM = 100_001 # 위치값의 범위 0 ~ 100,000
N, K = map(int, input().split())
visited = [False] * MAX_NUM # 방문 여부 기록
sec_list = [0] * MAX_NUM # 각 좌표에 도달할 때의 시간 기록

def bfs(): # bfs로 한칸 전, 후, 2배로 이동하는 3가지 경우를 q에 넣어 최단시간 기록
    q = deque()
    q.append(N) # 최초 시작점 삽입
    visited[N] = True # 최초 시작점 방문 체크
    sec_list[N] = 0 # 최초 시작점에선 시간은 0초

    while q:
        nxt = q.popleft()
        if nxt == K: # 동생의 위치에 도달시 함수 종료
            return
        if 0 <= nxt - 1 < MAX_NUM and not visited[nxt - 1]: # 한칸 앞이 범위 내에 있고 방문 안 했으면
            q.append(nxt - 1) # 큐에 넣고,
            visited[nxt - 1] = True # 방문 체크를 하고,
            sec_list[nxt - 1] = sec_list[nxt] + 1 # 현재까지 걸린 시간에 + 1 초
        if 0 <= nxt + 1 < MAX_NUM and not visited[nxt + 1]: # 한칸 뒤가 범위 내에 있고 방문 안 했으면, 이후 똑같음.
            q.append(nxt + 1)
            sec_list[nxt + 1] = sec_list[nxt] + 1
            visited[nxt + 1] = True
        if 0 <= nxt * 2 < MAX_NUM and not visited[nxt * 2]: # 순간이동(현재 위치에 2배)이 범위 내에 있고 방문 안 했으면, 이후 똑같음.
            q.append(nxt * 2)
            visited[nxt * 2] = True
            sec_list[nxt * 2] = sec_list[nxt] + 1

bfs()

print(sec_list[K]) # 동생의 위치에 도달했을 때의 걸린 시간 출력.

"""
5 17

"""
