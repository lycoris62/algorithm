"""
    오큰수 (Gold 4)
    https://www.acmicpc.net/problem/17298
"""

from collections import deque

n = int(input())
li = list(map(int, input().split()))
res = [-1] * n
stack = deque()

for i in range(n):
    while len(stack) != 0 and li[stack[-1]] < li[i]:
        res[stack.pop()] = li[i]
    stack.append(i)

print(*res)

"""
4
3 5 2 7

4
9 5 4 8

"""