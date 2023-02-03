N, B = map(int, input().split())
mat = [ list(map(int, input().split())) for _ in range(N)]

def multi(mat1, mat2):
    temp = [[0]*N for _ in range(N)]
    for start in range(N):
        for end in range(N):
            for mid in range(N):
                temp[start][end] += mat1[start][mid] * mat2[mid][end]
            temp[start][end] %= 1000
    return temp

def power(mat, n): # mat ^ n
    if n == 1:
        for start in range(N):
            for end in range(N):
                mat[start][end] %= 1000
        return mat

    temp = power(mat, n // 2)

    if n % 2 == 0:
        return multi(temp, temp)
    else:
        return multi(multi(temp, temp), mat)

for row in power(mat, B):
    print(*row)

"""
2 5
1 2
3 4

3 3
1 2 3
4 5 6
7 8 9

5 10
1 0 0 0 1
1 0 0 0 1
1 0 0 0 1
1 0 0 0 1
1 0 0 0 1

"""