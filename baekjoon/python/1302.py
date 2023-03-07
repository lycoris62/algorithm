"""
    1302 베스트셀러
    https://www.acmicpc.net/problem/1302
"""
import sys

input = sys.stdin.readline
n = int(input())
map = dict() # map 자료구조

for _ in range(n):
    str = input().rstrip('\n')
    if str in map: # 맵에 입력받은 키가 있다면 +1
        map[str] += 1
    else: # 없다면 0으로 초기화
        map[str] = 1
# list.sort() 는 list 를 바꾸지 않고 정렬한 후에 반환함. 그래서 그자체를 바꾸려면 sorted(list) 해야됨.
print(sorted([k for k,v in map.items() if max(map.values()) == v])[0])

"""
5
top
top
top
top
kimtop

9
table
chair
table
table
lamp
door
lamp
table
chair

6
a
a
a
b
b
b

8
icecream
peanuts
peanuts
chocolate
candy
chocolate
icecream
apple

1
soul

3
banana
grape
apple

"""