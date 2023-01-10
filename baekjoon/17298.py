n = int(input())
li = list(map(int, input().split()))
res = [-1] * n
stack = []


for i in range(n):
    while(len(stack) != 0 and li[stack[-1]] < li[i]):
        res[stack.pop()] = li[i]
    stack.append(i)

print(*res)
