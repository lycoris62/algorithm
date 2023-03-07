n=int(input())
m=int(input())

res = []

for num in range(n, m+1):
    if(num > 2):
        for i in range(2, num):
            if(num % i == 0): break
            res.append(num)

if(len(res) > 0):
    print(sum(res))
    print(min(res))
else:
    print(-1)
