import sys

N, M = map(int, input().split())
no_listen = set()
no_see = set()
input = sys.stdin.readline
for _ in range(N):
    no_listen.add(input().rstrip())
for _ in range(M):
    no_see.add(input().rstrip())

no_listen_no_see = no_listen.intersection(no_see)

print(len(no_listen_no_see))
for x in sorted(no_listen_no_see):
    print(x)

"""
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton

"""