"""
    피보나치 수 6 (Gold 2)
    https://www.acmicpc.net/problem/11444
"""

n = int(input())
OP = 1_000_000_007
mat = [
    [1, 1],
    [1, 0]
]

def multi_matrix(mat1, mat2):
    res = [
        [0, 0],
        [0, 0]
    ]

    for start in range(2):
        for end in range(2):
            for mid in range(2):
                res[start][end] += (mat1[start][mid] * mat2[mid][end]) % OP
    return res

def power(mat, n): # mat ^ n
    if n == 1:
        return mat
    else:
        temp = power(mat, n // 2)
        if n % 2 == 0:
            return multi_matrix(temp, temp)
        else:
            return multi_matrix(multi_matrix(temp, temp), mat)

print(power(mat, n)[0][1] % OP)

"""
1000

999999999999999999

"""