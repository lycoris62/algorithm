N, K = map(int, input().split())
goods = list(map(int, input().split())) # 전자제품 리스트
cnt = 0 # 플러그 갈아끼운 횟수
plugs = [] # 멀티탭 플러그

for i in range(K): # 전자제품을 하나하나 돌기
    # 멀티탭에 제품이 꽂혀있다면 패스
    if goods[i] in plugs:
        continue
    # 멀티탭 구가 비어있다면 채워 꽂기
    if len(plugs) < N:
        plugs.append(goods[i])
        continue

    goods_idxs = [] # 앞으로 남은 제품들 인덱스 리스트
    has_plug = True # 남은 제품들 중 기존에 꽂혀있는게 있는지 없는지 체크
    for j in range(N): # 멀티탭 구 개수 만큼 반복문
        if plugs[j] in goods[i:]: # 남은 제품들 중 플러그에 꽂혀있는 제품이 있다면
            goods_idx = goods[i:].index(plugs[j]) # 그 제품 인덱스를 넣기
        else: # 꽂혀있지 않으면,
            goods_idx = 101 # (K가 최대 100이므로) 있지 않을 값 넣기 
            has_plug = False # 안 꽂혀있으므로 

        goods_idxs.append(goods_idx) # 인덱스 리스트에 넣고, 
        if not has_plug: # 안 꽂혀 있다면 반복문 탈출. 
            break
    # 앞으로 재사용할 제품 중에 가장 나중에 있는 제품을 빼고 현재 제품으로 갈아끼움  
    # 2구 멀티탭 중 첫 번째 제품을 앞으로도 사용 안 하면 인덱스 0 제품을 뺌
    # 2구 멀티탭 중 두 번째 제품을 앞으로도 사용 안 하면 인덱스 1 제품을 뺌
    # 2구 멀티탭 중 둘 다 사용한다면 마지막 제품 (인덱스 1)을 뺌 
    plug_out = goods_idxs.index(max(goods_idxs)) 
    del plugs[plug_out]
    plugs.append(goods[i])
    cnt += 1 # 갈아끼웠으니 +1 

print(cnt)

"""
2 7
2 3 2 3 1 2 7

"""