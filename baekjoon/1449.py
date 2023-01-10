n, l = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
t = arr[0]
cnt = 1
for i in arr[1:]:
    if i < t + l:
        continue
    else:
        t = i
        cnt += 1

print(cnt)
