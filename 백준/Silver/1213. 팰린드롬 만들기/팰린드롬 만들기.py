"""
    팰린드롬 만들기 (Silver 3)
    https://www.acmicpc.net/problem/1213
"""

from collections import Counter

c = Counter(input())

if sum(i%2 for i in c.values()) > 1:
    print("I'm Sorry Hansoo")
else:
    half = ''
    for k, v in sorted(c.items()):
        half += k * (v//2)
    ans = half
    for k, v in c.items():
        if v % 2:
            ans += k
            break
    ans += half[::-1]
    print(ans)

"""
AABB

AAABB

ABACABA

ABCD

"""