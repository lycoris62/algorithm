from collections import deque

n = int(input()) # 빌딩 개수 
buildings = deque() # 각 빌딩을 왼쪽부터 층수 입력받는 리스트 
stack = deque() # 스택 
result = 0 # result

# 각 빌딩의 층수 입력 
for _ in range(n):
    buildings.append(int(input()))

# 각 빌딩마다 처리 
# 볼 수 있는 건물의 수를 세는 것이 아닌 (다른 건물에게) 보여지는 횟수를 세는게 핵심 
for building in buildings:
    # 각 빌딩마다 스택에 쌓다가 자기보다 작은 스택 요소가 나오면 빼서 (다른 건물에) 보여지는 횟수를 체크 
    while stack and stack[-1] <= building:
        stack.pop()
    #stack.append(building)
    #result += len(stack) - 1 # 스택 개수에서 자기자신을 뺀 개수 == (다른 건물에게) 보여진 횟수 
    result += len(stack) # 스택 개수에서 자기자신을 뺀 개수 == (다른 건물에게) 보여진 횟수 
    stack.append(building)
print(result)
