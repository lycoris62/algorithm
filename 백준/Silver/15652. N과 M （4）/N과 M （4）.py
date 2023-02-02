N, M = map(int, input().split())
s = []
def bt(start):
    if len(s) == M:
        print(*s)
        return
    else:
        for i in range(start, N+1):
            s.append(i)
            bt(i)
            s.pop()

bt(1)