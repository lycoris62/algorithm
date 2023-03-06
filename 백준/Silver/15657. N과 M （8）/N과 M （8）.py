N, M = map(int, input().split())
li = sorted(list(map(int, input().split())))
s = []
def bt(start):
    if len(s) == M:
        print(*s)
        return
    else:
        for x in li[li.index(start):]:
            s.append(x)
            bt(x)
            s.pop()

bt(li[0])

"""
3 1
4 5 2

4 2
9 8 7 1

4 4
1231 1232 1233 1234

"""