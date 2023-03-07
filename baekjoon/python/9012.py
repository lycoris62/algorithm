n = int(input())

def checkVPS(st):
    num = 0
    li = list(st)
    for c in li:
        if c == '(':
            num += 1
        else:
            num -= 1
        if num < 0:
            print("NO")
            return
    res = "YES" if num == 0 else "NO"
    print(res)
    return

for _ in range(n):
    checkVPS(input())
    
