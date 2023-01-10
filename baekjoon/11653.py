"""
    11653 소인수분해
    https://www.acmicpc.net/problem/11653
"""
n = int(input())
op = 2
while(n > 1):
    if n % op == 0:
        print(op)
        n = n // op
    else:
        op += 1