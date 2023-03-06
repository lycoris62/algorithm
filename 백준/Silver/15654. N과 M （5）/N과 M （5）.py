N, M = map(int, input().split())
li = sorted(list(map(int, input().split())))
s = []
def bt():
    if len(s) == M:
        print(*s)
        return
    else:
        for x in li:
            if x not in s:
                s.append(x)
                bt()
                s.pop()

bt()

"""
3 1
4 5 2

4 2
9 8 7 1

4 4
1231 1232 1233 1234

"""