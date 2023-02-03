N, M = map(int, input().split())
li = sorted(set(map(int, input().split())))
s = []

def bt(start):
    if len(s) == M:
        print(*s)
        return
    for x in li[li.index(start):]:
        s.append(x)
        bt(x)
        s.pop()

bt(li[0])

"""
3 1
4 4 2

4 2
9 7 9 1

4 4
1 1 2 2

"""