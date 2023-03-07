"""
    탑 (Gold 5)
    https://www.acmicpc.net/problem/2493
"""

from collections import deque

n = int(input())
buildings = list(map(int, input().split()))
st = deque() # 스택 이용
res = []

# 각 건물마다 반복문을 돌리면 시간초과가 남
# 각 건물을 한번씩만 돌면서 그 건물이 쏜 신호에 맞는 건물을 스택으로 찾기.

for i in range(n):
    while st: # 스택에 쌓여 있고,
        if st[-1][0] > buildings[i]: # 스택 꼭대기의 건물 층수가 현재 건물보다 높다면,
            res.append(st[-1][1]) # 쏜 신호가 맞았다는 뜻이므로 정답에 건물 번호(인덱스) 넣어놓고,
            break # 반복문 빠져나감.
        else: # 건물 층수가 같거나 낮다면,
            st.pop() # 이후로도 신호 맞을 일이 없으므로 스택에서 뺌.
    if not st: # 스택이 비었다면 (= 자기 왼쪽 건물들은 다 자기보다 낮거나 없다면)
        res.append(0) # 정담에 0 넣음.
    st.append((buildings[i], i+1)) # ( 건물 층수, 건물 번호(인덱스) ) 로 스택에 저장

print(*res) # 정답 출력

"""
5
6 9 5 7 4

"""