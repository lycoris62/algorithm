A = []
B = []

na, ma = map(int, input().split())
for _ in range(na):
    A.append(list(map(int, input().split())))
    
nb, mb = map(int, input().split())
for _ in range(nb):
    B.append(list(map(int, input().split())))
"""
def con(i, j):
    temp = 0
    idx = 0
    for n in A[i]:
        temp += n * B[idx][j]
        idx += 1
    #R[i][j] = temp
    print(temp, end=' ')

#R = [ [0] * mb for _ in range(na) ]

for i in range(na):
    for j in range(mb):
        con(i, j)
    print()
"""

for n in range(na):
    for m in range(mb):
        temp = 0
        for k in range(ma):
            temp += A[n][k] * B[k][m]
        print(temp, end=' ')
    print()
