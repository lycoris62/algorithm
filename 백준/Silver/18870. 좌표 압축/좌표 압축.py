N = int(input())
coords = list(map(int, input().split()))
dict = {value: key for key, value in enumerate(sorted(set(coords)))}
print(*[dict[coord] for coord in coords])

"""
5
2 4 -10 4 -9

6
1000 999 1000 999 1000 999

"""
