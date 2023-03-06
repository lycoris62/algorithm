import sys

N = int(input())
dp = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

for i in range(1, N):
    dp[i][0] += min(dp[i-1][1], dp[i-1][2])
    dp[i][1] += min(dp[i-1][0], dp[i-1][2])
    dp[i][2] += min(dp[i-1][0], dp[i-1][1])

print(min(dp[N-1]))

"""
3
26 40 83
49 60 57
13 89 99

3
1 100 100
100 1 100
100 100 1

3
1 100 100
100 100 100
1 100 100

6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91

8
71 39 44
32 83 55
51 37 63
89 29 100
83 58 11
65 13 15
47 25 29
60 66 19

"""
