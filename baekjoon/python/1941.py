li = [ input() for _ in range(5) ]
delta = [ (-1,0), (1,0), (0,-1), (0,1) ]
res_set = set()

# 백트래킹
# arr: 지금까지 거쳐간 좌표 리스트, idx: 탐색횟수(0부터 시작), s: 이다솜파 수, y: 임도연파 수
def bt(arr, s, y): 
    if y > 3: # 임도연파 수가 다수이므로 탐색을 종료 
        return
    if (len(arr) - 1) == 6: # 7번의 탐색을 마쳤고 이다솜파가 다수이면, 
        arr.sort() # 현재까지 거쳐간 좌표들을 정렬 후 (좌표의 순서는 상관없고 유일을 보장하기 위해)
        res_set.add(tuple(arr)) # 결과 집합에 추가 (set 으로 중복 제거) 
    else:
        adjs = [] # 인접 좌표들 리스트
        
        for node in range(len(arr)): # 현재까지 거쳐간 좌표들의 인접 좌표를 체킹 
            for i in range(4): # 인접 상하좌우 체크 
                dx = arr[node][0] + delta[i][0]
                dy = arr[node][1] + delta[i][1]

                if not ( 0 <= dx < 5 and 0 <= dy < 5 ): # 범위를 벗어나는 좌표 패스 
                    continue
                if (dx, dy) in arr: # 현재까지 거쳐간 좌표이면 있으면 패스 
                    continue
                adjs.append((dx, dy)) # 탐색하기 위해 추가
        
        # 추가된 인접 좌표들중에 이다솜파이면 s 추가 후 탐색, 임도연파면 y 추가 후 탐색 
        for adj in adjs:
            nx = adj[0]
            ny = adj[1]
            if li[nx][ny] == 'S':
                bt(arr + [(nx, ny)], s + 1, y)
            else:
                bt(arr + [(nx, ny)], s, y + 1)

for i in range(5):
    for j in range(5):
        if li[i][j] == 'S': # 첫 이다솜파를 만날 시 탐색을 시작하므로 s는 1부터 시작 
            bt([(i, j)], 1, 0)

print(len(res_set))
