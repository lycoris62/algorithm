from collections import deque
import sys

n = int(sys.stdin.readline())
li = deque([])

for _ in range(n):
    strr = sys.stdin.readline()
    order = strr.split()[0]
    if order == "push":
        li.append(int(strr.split()[1]))
    elif order == "pop":
        print(li.popleft() if len(li) != 0 else -1)
    elif order == "size":
        print(len(li))
    elif order == "empty":
        print(0 if len(li) != 0 else 1)
    elif order == "front":
        print(li[0] if len(li) != 0 else -1)
    elif order == "back":
        print(li[-1] if len(li) != 0 else -1)
    
