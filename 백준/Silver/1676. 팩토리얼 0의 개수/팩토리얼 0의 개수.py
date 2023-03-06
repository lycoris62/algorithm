import math

n = int(input())
res = 0
for x in str(math.factorial(n))[::-1]:
    if x == '0':
        res += 1
    else:
        break
print(res)