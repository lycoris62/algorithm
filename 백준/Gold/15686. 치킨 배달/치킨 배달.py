"""
    치킨 배달 (Gold 5)
    https://www.acmicpc.net/problem/15686
"""

import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())

city = list(list(map(int, input().split())) for _ in range(n))
res = sys.maxsize
house = []
chick = []

for i in range(n): # 도시 전체를 돌면서
    for j in range(n):
        if city[i][j] == 1: # 집을 발견하면 집들 리스트에 넣기 
            house.append([i, j])
        elif city[i][j] == 2: # 치킨집을 발견하면 치킨집 리스트에 넣기 
            chick.append([i, j])

for chi in combinations(chick, m): # 치킨집이 m개인 조합을 만들어서 경우의 수를 for문 돌림. 
    temp = 0 # 전체 치킨 거리를 더하기 위한 임시값 
    for h in house: # 전체 집을 돌면서 집집마다의 치킨 거리 구하기 
        chi_len = sys.maxsize 
        for j in range(m): # m개의 치킨집 중 최소의 치킨 거리 구하기. 
            chi_len = min(chi_len, abs(h[0] - chi[j][0]) + abs(h[1] - chi[j][1]))
        temp += chi_len # 집 하나의 최소 치킨 거리 더하기 

    res = min(res, temp) # 경우의 수 중에서 최솟값 저장 
print(res) # 출력 

"""
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2

5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0

5 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1

"""