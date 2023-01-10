n = int(input())

li = [ list(map(int, input().split())) for _ in range(n) ]

nums = [0, 0, 0]

def rec(l, n, m):
    fn = li[n][m]
    is_break = False
    is_diff = False
    
    for i in range(n, n + l):
        for j in range(m, m + l):
            if fn != li[i][j]:
                is_diff = True
                is_break= True
                break
        if is_break:
            break
        
    if is_diff:
        l = l // 3
        rec(l, n, m)
        rec(l, n, m + l)
        rec(l, n, m + 2 * l)
        
        rec(l, n + l, m)
        rec(l, n + l, m + l)
        rec(l, n + l, m + 2 * l)
        
        rec(l, n + 2 * l, m)
        rec(l, n + 2 * l, m + l)
        rec(l, n + 2 * l, m + 2 * l)
    else:
        nums[fn + 1] += 1

rec(n, 0, 0)

for i in nums:
    print(i)
