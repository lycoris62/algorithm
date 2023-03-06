import sys

M = int(input())
S = set()

for _ in range(M):
    op = sys.stdin.readline().rstrip().split()
    if len(op) == 1:
        if op[0] == "all":
            S = set([i for i in range(1, 21)])
        else:
            S = set()
    else:
        func, num = op[0], int(op[1])

        if func == "add":
            S.add(num)
        elif func == "remove":
            S.discard(num)
        elif func == "check":
            print(1 if num in S else 0)
        elif func == "toggle":
            if num in S:
                S.discard(num)
            else:
                S.add(num)

"""
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1

"""