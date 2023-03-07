X = int(input())
N = int(input())
li = []
for _ in range(N):
    li.append(tuple(map(int, input().split())))

sum = 0

for price, num in li:
    sum += price * num
res = "Yes" if sum == X else "No"

print(res)
