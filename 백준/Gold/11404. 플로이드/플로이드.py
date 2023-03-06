import math

n = int(input())
m = int(input())

graph = [[math.inf] * n for _ in range(n)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a-1][b-1] = min(graph[a-1][b-1], c)

for mid in range(n):
    for start in range(n):
        for end in range(n):
            if start == end:
                continue
            graph[start][end] = min(graph[start][end], graph[start][mid] + graph[mid][end])

for row in graph:
    print(*[x if x != math.inf else 0 for x in row])

"""
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

"""