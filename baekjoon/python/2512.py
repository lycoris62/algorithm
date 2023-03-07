"""
    예산
    https://www.acmicpc.net/problem/2512
"""

n = int(input())

li = list(map(int, input().split()))
m = int(input())
minn = 0
maxx = max(li)
mid = (maxx + minn) // 2
ans = 0

def is_possible(mid): # 상한선을 mid로 한 각 지방의 예산합이 총 예산 이하인지 체크하는 함수.
    return sum(min(mid, r) for r in li) <= m
# 이진탐색
while minn <= maxx:
    if is_possible(mid): # 예산이 초과가 안 되면,
        minn = mid + 1 # 최솟값을 하한선으로 재정의
        ans = mid
    else: # 예산 초과가 나면,
        maxx = mid - 1 # 최댓값을 상한선으로 재정의
    mid = (minn + maxx) // 2

print(ans)

"""
4
120 110 140 150
485

5
70 80 30 40 100
450

"""