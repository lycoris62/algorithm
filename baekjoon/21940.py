import sys
from math import inf

input = sys.stdin.readline

n, m = map(int, input().split())
graph = [ [ 0 if x == y else inf for y in range(n + 1) ] for x in range (n + 1) ]

for _ in range(m):
    x, y, pay = map(int, input().split())
    graph[x][y] = min(graph[x][y], pay)

for mid in range(1, n+1):
    for end in range(1, n+1):
        for start in range(1, n+1):
            if graph[start][end] > graph[start][mid] + graph[mid][end]:
                graph[start][end] = graph[start][mid] + graph[mid][end]

k = int(input())
friend_li = list(map(int, input().split()))
min_value = inf
min_li = []

for city in range(1, n+1):
    temp_max = 0
    for p_num in friend_li:
        if graph[p_num][city] + graph[city][p_num] > temp_max:
            temp_max = graph[p_num][city] + graph[city][p_num]

    if temp_max < min_value:
        min_value = temp_max
        min_li = [city]
    elif temp_max == min_value:
        min_li.append(city)

print(*min_li)

