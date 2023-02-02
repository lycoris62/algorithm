import heapq
import sys

N = int(input())
# 강의들 시간표를 전부 입력 받기 
lectures = sorted([tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)])

rooms = [] # 강의실 개수 체크 & 각 강의실의 끝나는 시간만 입력받음 
heapq.heappush(rooms, lectures[0][1]) # 우선순위큐로 맨 첫 수업의 끝나는 시간을 입력. 

for i in range(1, N): # 2번째 수업부터 N번째 수업까지 돌림 
    now_start, now_end = lectures[i] # 가독성을 위해 현재 수업의 시작, 끝 시간 가져옴 
    past_end = rooms[0] # 강의실 중 가장 빨리 끝나는 시간을 가져옴

    if now_start < past_end: # 현재 수업이 가장 빨리 끝나는 시간보다 일찍 시작할 때 
        heapq.heappush(rooms, now_end) # 새 강의실을 추가, 현재 수업의 끝나는 시간을 넣어줌 
    else: # 수업이 안 겹치면, 
        heapq.heappop(rooms) # 강의실 중 가장 빨리 끝나는 수업을 뺌 
        heapq.heappush(rooms, now_end) # 현재 수업의 끝나는 시간을 넣어줌 

print(len(rooms)) # 강의실 수 출력 

"""
3
1 3
2 4
3 5

"""