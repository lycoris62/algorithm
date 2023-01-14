"""
    외계인의 기타 연주 (Silver 1)
    https://www.acmicpc.net/problem/2841
"""

from collections import deque
import sys

input = sys.stdin.readline # 입력이 최대 500,001 번 받으므로 이렇게 해주었다.

N, P = map(int, input().split()) # 음 개수 N, 프랫 개수 P
arr = [[] for _ in range(6)] # 기타줄은 6개 이고, 각 줄의 프렛은 다른 줄에 영향 못 미치니 6개의 배열 생성
count = 0 # 총 손가락을 움직인 횟수를 저장.

for _ in range(N):
    line_num, fret = map(int, input().split())
    arr[line_num - 1].append(fret) # 줄 번호가 1~6으로 들어오므로 인덱싱 0~5으로 바꿔서 저장.

for i in range(6): # 0번줄부터 5번줄까지 각각 따로 돌림.
    li = arr[i] # i번째 줄의 배열을 가져와서,
    if not li: # 배열이 비었으면(= 이 줄에서 칠 음이 없으면)
        continue # 다음 줄로 이동

    stack = deque() # 스택 자료구조 이용.

    for x in li: # 음이 입력된 순서대로 연주가 된다.
        while stack: # 만약 스택이 쌓여있으면,
            if stack[-1] < x: # 스택의 peek이 현재 음보다 작으면(= 더 높은 음을 쳐야하면)
                stack.append(x) # 현재 음을 스택에 넣는다.
                count += 1 # 현재 음을 쳐야하므로(= 손가락으로 프렛을 눌러야 하므로) 횟수 +1
                break # 다음 프렛을 확인해야하므로 while문을 나간다.
            elif stack[-1] > x: # 스택의 peek이 현재 음보다 낮으면(= 기존에 눌러놨던 높은 음의 손가락을 떼야하면)
                stack.pop() # 스택에서 뺀다.(= 손가락을 뗀다.)
                count += 1 # 손가락을 뗐으므로 횟수를 +1 한다.
            else: # 스택의 peek과 현재 음이 같아서 손가락을 움직일 필요가 없다면
                break # 현상 유지한 채로 다음 음을 확인한다.

        if not stack: # 만약 줄을 누르고 있는 손가락이 하나도 없으면,
            stack.append(x) # 현재 음을 누르고
            count += 1 # 손가락을 움직였으므로 횟수를 +1 한다.

print(count)

"""
5 15
2 8
2 10
2 12
2 10
2 5

7 15
1 5
2 3
2 5
2 7
2 4
1 5
1 3

"""