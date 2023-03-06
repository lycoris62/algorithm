N, M = map(int, input().split())
li = sorted(list(map(int, input().split())))
s = []
visited = [False] * N

def bt():
    if len(s) == M:
        print(*s)
        return
    temp = 0

    for i in range(N):
        if not visited[i] and temp != li[i]:
            visited[i] = True
            s.append(li[i])
            temp = li[i]
            bt()
            visited[i] = False
            s.pop()

bt()

"""
3 1
4 4 2

4 2
9 7 9 1

4 4
1231 1232 1233 1234

"""