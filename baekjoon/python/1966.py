from collections import deque

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    li = deque(list(map(int, input().split())))
    arr = deque([0 for _ in range(n) ])
    arr[m] = 1
    
    cnt = 0
    while True:
        if li[0] == max(li):
            cnt += 1
            if arr[0] == 1:
                print(cnt)
                break
            else:
                li.popleft()
                arr.popleft()
        else:
            li.rotate(-1)
            arr.rotate(-1)
    
    
