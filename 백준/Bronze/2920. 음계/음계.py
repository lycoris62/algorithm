"""
    음계 (Bronze 2)
    https://www.acmicpc.net/problem/2920
"""

li = list(map(int,input().split()))
li_sort1 = sorted(li)
li_sort2 = li_sort1[::-1]
if li == li_sort1:
    print("ascending")
elif li == li_sort2:
    print("descending")
else:
    print("mixed")

"""
1 2 3 4 5 6 7 8

8 7 6 5 4 3 2 1

8 1 7 2 6 3 5 4

"""