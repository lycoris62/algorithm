"""
    직각 삼각형 (Bronze 3)
    https://www.acmicpc.net/problem/4153
"""

while True:
    li = sorted(list(map(lambda x: x ** 2, map(int, input().split()))))
    if li[0] == 0:
        break
    print("right" if li[0] + li[1] == li[2] else "wrong")

"""
6 8 10
25 52 60
5 12 13
0 0 0

"""