n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
cnt = 0
for c in coin[::-1]:
    cnt += k // c
    k %= c
    if k == 0:
        break
print(cnt)
