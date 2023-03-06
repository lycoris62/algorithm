"""
    행렬 덧셈 (Bronze 5)
    https://www.acmicpc.net/problem/2738
"""

N, M = map(int, input().split())

A = [list(map(int, input().split())) for _ in range(N)]
B = [list(map(int, input().split())) for _ in range(N)]

for start in range(N):
    for end in range(M):
        A[start][end] = A[start][end] + B[start][end]

for row in A:
    print(*row)

"""
3 3
1 1 1
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100

"""