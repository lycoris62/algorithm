from collections import deque

A, B = map(int, input().split())

def bfs():
    q = deque()
    q.append((A, 1))
    while q:
        nxt, cnt = q.popleft()
        if nxt == B:
            return cnt
        if nxt < B:
            q.append((nxt * 2, cnt + 1))
            q.append((nxt * 10 + 1, cnt + 1))
    return -1

print(bfs())

"""
2 162

4 42

100 40021

"""