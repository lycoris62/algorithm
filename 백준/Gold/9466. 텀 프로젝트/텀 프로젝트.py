"""
    텀 프로젝트 (Gold 3)
    https://www.acmicpc.net/problem/9466
"""

import sys
sys.setrecursionlimit(10 ** 7) # 파이썬의 최대 재귀 실행 횟수는 정해져 있으므로 해금해줘야함

def dfs(x):
    global cycle_count

    visited[x] = True # 현재 학생(노드) 방문 체크 (테스트 케이스 동안 유지되는 변수)
    visit_list.append(x) # 방문한 학생을 리스트에 추가 ( 이어져 있는 그래프 동안만 유지되는 변수)

    num = li[x] # 현재 학생이 선택한 학생 번호.
    if visited[num]: # 그 번호를 방문했고,
        if num in visit_list: # 그게 x부터 시작해서 이어지는 하나의 사이클이라면,
            # 2->4->5->3->4 로 이어졌다면 2를 제외한 4,5,3만 추가해야하므로 밑과 같이 작성. 
            cycle_count += visit_list[visit_list.index(num):]
        return
    else: # 방문하지 않았으면 계속 이어진 다음 학생으로 이동. 
        dfs(num)

for _ in range(int(input())): # 테스트케이스 반복.
    n = int(input()) # 학생 수 입력.
    # 인덱스를 0~n-1 로 변경 후 리스트화, 0~n-1번의 학생이 각자 선택한 학생 수를 0~n-1사이값으로 입력받음.
    li = list(map(lambda x:x-1, map(int, input().split())))

    visited = [False] * n # 0~n-1 번 학생에게 방문 했는지 체크용 리스트
    cycle_count = [] # 사이클 개수를 계산하기 위해 사이클에 해당하는 학생을 모아놓는 리스트.

    for i in range(n): # 0 ~ n-1 학생을 차례로 돌아가며 사이클 찾기.
        if not visited[i]: # 아직 방문하지 않은 학생(노드)라면,
            visit_list = [] # 새로운 사이클을 발견할 수도 있기 때문에 방문할 학생을 입력받음
            dfs(i) # 현재 학생부터 이어져 있는 학생들을 도는 dfs 실행
    
    # 사이클을 형성하지 못하는 학생수를 출력하므로, 전체 학생수 - 사이클 형성 학생수
    print(n - len(cycle_count))

"""
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8

"""