import sys

n = int(input()) 
num = list(map(int, input().split())) # 수열 입력 
op = list(map(int, input().split())) # 연산자 입력 

max_min = [ -sys.maxsize + 1, sys.maxsize ] # 최댓값 최솟값 리스트 

def dfs(depth, total, plus, minus, multi, divide):
    if depth == n: # 모든 연산을 다 하면 
        max_min[0] = max(total, max_min[0]) # 최댓값을 비교하여 저장 
        max_min[1] = min(total, max_min[1]) # 최솟값을 비교하여 저장 
        return
    
    # elif 가 아닌 이유는 모든 경우를 다 돌리기 위해서 
    if plus:
        dfs(depth+1, total+num[depth], plus-1, minus, multi, divide)
    if minus:
        dfs(depth+1, total-num[depth], plus, minus-1, multi, divide)
    if multi:
        dfs(depth+1, total*num[depth], plus, minus, multi-1, divide)
    if divide:
        # 풀이조건 중 "양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것" 때문에 // 안 씀
        dfs(depth+1, int(total/num[depth]), plus, minus, multi, divide-1)
    
dfs(1, num[0], op[0], op[1], op[2], op[3])

print(max_min[0])
print(max_min[1])
