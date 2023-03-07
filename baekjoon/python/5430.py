from collections import deque

t = int(input())
for _ in range(t):
    orders = input().strip()
    #orders = 
    n = int(input())
    listr = input()
    li = deque(listr[1:-1].split(',')) if n != 0 else deque([])
    isError = False
    flag = 0
    for order in orders:
        if order == 'R':
            flag += 1
        elif order == 'D':
            if len(li) == 0:
                    #break
                    print("error")
                    isError = True
                    break
                    #exit(0)
            else:
                if flag % 2 == 0:
                    li.popleft()
                else:
                    li.pop()
    # print(li if len(li) != 0 else "error")
    if isError:
        continue
    else:
        if flag % 2 == 0:
            print("[" + ",".join(li) + "]")
        else:
            li.reverse()
            print("[" + ",".join(li) + "]")
                
