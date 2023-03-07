"""
    10815 숫자 카드
    https://www.acmicpc.net/problem/10815
"""

from bisect import bisect_left, bisect_right

n = int(input())
cards = list(map(int, input().split()))
cards.sort() # 이진탐색 전에 정렬은 필수.
m = int(input())
ans = []
query = list(map(int, input().split()))

for q in query:
    l = bisect_left(cards, q)
    r = bisect_right(cards, q)
    # 또다른 방법으로, if cards[l] == q 이면 1
    ans.append(1 if r - l > 0 else 0) # 아니면 1 if r - l else 0
print(*ans)

"""
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10

"""