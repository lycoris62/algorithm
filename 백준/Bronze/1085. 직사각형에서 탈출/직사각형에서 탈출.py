x, y, w, h = map(int, input().split())
print(min(x, y, w-x, h-y))

"""
6 2 10 3

1 1 5 5

653 375 1000 1000

161 181 762 375

"""