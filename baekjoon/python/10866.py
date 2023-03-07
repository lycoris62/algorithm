from collections import deque
import sys

n = int(sys.stdin.readline())
li = deque()

for _ in range(n):
    strr = sys.stdin.readline()
    o = strr.split()[0]

    if o == "push_back":
        li.append(int(strr.split()[1]))
    elif o == "push_front":
        li.appendleft(int(strr.split()[1]))
    elif o == "pop_front":
        print(li.popleft() if len(li) != 0 else -1)
    elif o == "pop_back":
        print(li.pop() if len(li) != 0 else -1)
    elif o == "size":
        print(len(li))
    elif o =="empty":
        print(1 if len(li) == 0 else 0)
    elif o == "front":
        print(li[0] if len(li) != 0 else -1)
    elif o == "back":
        print(li[-1] if len(li) != 0 else -1)
