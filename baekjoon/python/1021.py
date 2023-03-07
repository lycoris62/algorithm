from collections import deque

n, m = map(int, input().split())
ids = list(map(int, input().split()))
li = deque(list(range(1, n + 1)))
cnt = 0

for idx in ids:
    #print(li, cnt)
    while True:
        if idx == li[0]:
            li.popleft()
            break
        find_idx = li.index(idx)
        length = len(li) - find_idx
        if find_idx <= length:
            li.rotate(-1 * find_idx)
            cnt += find_idx
            #print(li, "left")
        else:
            li.rotate(length)
            cnt += length
            #print(li, "right")
        
print(cnt)
