N = int(input())
li = [ [] for _ in range(N) ]
for i in range(N):
    li[i] = list(map(int, input().split()))
color = [0, 0]
    
def checkColor(line, fx, fy):
    fc = li[fy][fx]
    isDiff = False

    if line == 1:
        if fc == 1:
            color[fc] += 1
        else:
            color[fc] += 1
        return
    
    is_break = False
    for m in range(line):
        for n in range(line):
            if li[fy + m][fx + n] != fc:
                isDiff = True
                is_break = True
                break
        if is_break:
            break
    if isDiff == True:
        line = line // 2
        checkColor(line, fx, fy)
        checkColor(line, fx + line, fy)
        checkColor(line, fx, fy + line)
        checkColor(line, fx + line, fy + line)
    else:
        if fc == 1:
            color[fc] += 1
        else:
            color[fc] += 1
        return

checkColor(N, 0, 0)
print(color[0])
print(color[1])
