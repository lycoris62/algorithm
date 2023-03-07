n = int(input())

li = [ list(map(int, input())) for _ in range(n) ]

def rec(l, n, m):
    check = li[n][m]
    isBreak = False
    for i in range(n, n + l):
        for j in range(m, m + l):
            if check != li[i][j]:
                check = -1
                isBreak = True
                break
        if isBreak:
            break
    if check == -1:
        print('(', end='')
        l = l // 2
        rec(l, n, m)
        rec(l, n, m + l)
        rec(l, n + l, m)
        rec(l, n + l, m + l)
        print(')', end='')
    else:
        print(1 if check == 1 else 0, end='')
rec(n, 0, 0)
