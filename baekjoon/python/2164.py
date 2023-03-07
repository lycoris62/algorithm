from collections import deque

n = int(input())
li = deque(list(range(1, n + 1))) # deque(range(1, n + 1)) 도 가능

while len(li) != 1:
    li.popleft()
    li.rotate(-1)
    
print(li[0]) # or print(li.popleft())

