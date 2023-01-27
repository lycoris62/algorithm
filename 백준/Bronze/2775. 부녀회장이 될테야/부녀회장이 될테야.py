"""
    2775 부녀회장이 될테야
    https://www.acmicpc.net/problem/2775
"""

T = int(input())

for _ in range(T):
    k = int(input())
    n = int(input())
    apart = [[1] * n for _ in range(k+1)]
    for i in range(n):
        apart[0][i] = i + 1

    for i in range(1, k+1):
        for j in range(1, n):
            apart[i][j] = apart[i][j-1] + apart[i-1][j]

    print(apart[k][n-1])

"""
2
1
3
2
3

"""