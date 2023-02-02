from itertools import combinations

N, M = map(int, input().split())

for ele in combinations([i for i in range(1, N+1)], M):
    print(*ele)

"""
3 1

4 2

4 4

"""