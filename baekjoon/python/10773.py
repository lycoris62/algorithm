n = int(input())

li = []
sum = 0

for _ in range(n):
    tmp = int(input())
    if (tmp == 0 and len(li) != 0) :
        sum -= li.pop()
    else:
        li.append(tmp)
        sum += tmp
print(sum)

