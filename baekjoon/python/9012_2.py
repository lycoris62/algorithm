n = int(input())

def st(str):
    i = 0
    for s in str:
        if s == '(':
            i += 1
        else:
            i -= 1
        if i < 0:
            return "NO"
    
    return "YES" if i == 0 else "NO"

for _ in range(n):
    print(st(input()))
