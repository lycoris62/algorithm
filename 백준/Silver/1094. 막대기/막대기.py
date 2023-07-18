from collections import deque

X = int(input())
li = deque([64])

while True:
    if sum(li) == X:
        break
    if sum(li) - li[-1] // 2 >= X:
        e = li.pop()
        li.append(e // 2)
    else:
        e = li.pop()
        li.append(e // 2)
        li.append(e // 2)

print(len(li))