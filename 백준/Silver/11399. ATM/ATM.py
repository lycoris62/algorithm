N = int(input())
times = sorted(list(map(int, input().split())), key=lambda x:-x)
print(sum([(idx + 1) * value for idx, value in enumerate(times)]))

"""
5
3 1 4 3 2

"""