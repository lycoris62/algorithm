from collections import deque

n, k = map(int, input().split())

li = deque(list(range(1, n + 1)))

print("<", end="")
while len(li) != 1:
    li.rotate(-1 * ( k - 1 ))
    print(li.popleft(), end=", ")
print(f"{li[0]}>")
