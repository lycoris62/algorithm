"""
    선 긋기 (Gold 5)
    https://www.acmicpc.net/problem/2170
"""

import sys

n = int(input())
li = sorted([tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)])
ans = 0
left, right = li[0] # x-y 2차원 평면인줄 알았는데 1차원으로 생각하는 거였다.   

for i in range(1, n):
    now_left, now_right = li[i] # 현재 좌, 우 좌푯값 

    if now_right <= right: # 기존 선 안에 있으면 패스 
        continue

    # 현재 좌, 우 사이에 기존 오른쪽 값에 속하면 오른쪽 값을 최대로 수정 
    elif now_left <= right < now_right: 
        right = now_right

    # 새로운 선이 시작하면 기존 선은 ans에 더해주고 좌, 우값 갱신 
    elif right < now_left:
        ans += right - left
        left = now_left
        right = now_right

ans += right-left # 마지막 선 더해줌 
print(ans)

"""
4
1 3
2 5
3 5
6 7

"""
