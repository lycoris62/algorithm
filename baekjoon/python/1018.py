"""
    체스판 다시 칠하기 (Silver 4)
    https://www.acmicpc.net/problem/1018
"""

import sys

N, M = map(int, input().split()) # N행 M열 입력.
board = [ list(input()) for _ in range(N) ] # 보드 완성.
res = sys.maxsize # 최솟값을 구해야 하므로 최댓값으로 설정. (최대가 64칸이므로 64로 해도 됨)

def search(x, y): # 8*8칸을 돌면서 (0, 0) 좌표가 흰색인 경우랑 검은색인 경우일 때 체스판과 틀린 경우를 카운팅.
    global res # 전역변수 선언
    arr = [row[y : y + 8] for row in board[x : x + 8]] # 보드칸 중에서 (x~x+8, y~y+8) 행렬만 따로 가져옴.
    color = ['W', 'B'] # 시작점(0, 0)이 흰색인 경우랑 검은색인 경우를 둘 다 서칭하기위해 선언.
    cnt = [0, 0] # 흰색인 경우랑 검은색인 경우의 틀린 횟수를 카운팅하기 위한 배열.
    for i in range(8):
        for j in range(8): # i행 j열일 때,
            # 체스판을 보면 (i + j)가 짝수인 경우랑 홀수인 경우는 각각 색깔이 같다. 이를 이용한다.
            # (i, j) 좌푯값이 원하는 색깔이 아닌 경우에 각각 cnt의 다른 요소를 +1 해준다.
            if arr[i][j] != color[(i + j) % 2]:
                cnt[0] += 1
            else:
                cnt[1] += 1
    res = min(res, *cnt) # 시작점이 흰색인 경우, 검은색인 경우, 기존의 최솟값 중에서 최솟값을 구해서 다시 최솟값을 설정.

for i in range(N-7): # 한번에 8칸씩 돌기 떄문에 전체 보드 행과 열의 -7 을 해준다.
    for j in range(M-7):
        search(i, j)

print(res)

"""
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW

10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB

8 8
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB

9 23
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBW

10 10
BBBBBBBBBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBWBWBWBWB
BWBWBWBWBB
BBBBBBBBBB

8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWWWB
BWBWBWBW

11 12
BWWBWWBWWBWW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW
BWWBWBWWWBWW
WBWWBWBBWWBW
BWWBWBBWWBWW
WBWWBWBBWWBW

"""