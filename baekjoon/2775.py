"""
    2775 부녀회장이 될테야
    https://www.acmicpc.net/problem/2775
"""


j = int(input())

arr = []
temparr = []
for i in range(j * 2):
    temparr.append(int(input()))
    if(i % 2 == 1):
        arr.append(temparr)
        temparr = []

t = int(input())
for _ in range(t):
    k = int(input())
    n = int(input())


'''
1 9 45
1 8 36 120
1 7 28  84
1 6 21  56
1 5 15  35 70
1 4 10  20 35
1 3  6  10 15 21
1 2  3   4  5  6 7 8

0
1
3 4 5 6 7 8 9
6 10 15 21 28 36
10
15
'''

def getPeople(arr):
    k,n=arr
    num = 0
    for i in range(n-1):
        num += (i + 1)
    res = num
    for j in range(k):
        res += (num + j)
    return res
for ar in arr:
    print(getPeople(ar))
