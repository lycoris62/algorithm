"""
재귀는 종료 조건이 있는 반복 작업을 인풋 개수를 줄여 반복해나가는 것
종료 조건:
    블럭(=인풋 개수)이 1개면: 
        출발 위치에서 도착 위치로 옮기기 
반복 작업:
    마지막 블럭을 제외한 위의 모든 블럭을 임시 위치로 옮기고,
    마지막 블럭을 도착 위치로 옮긴 뒤
    임시 위치의 블럭을 도착 위치로 옮기기 
"""
def hanoi(block, one, two, three): # 각 인수로 남은 블럭수, 출발 위치, 임시 위치, 도착 위치 
    # 종료 조건 
    if block == 1: # 블럭(=n)이 1개면
        print(one, three)
    # 종료 조건이 아니면 재귀
    else:
        # 마지막 블럭을 제외한 위의 모든 블럭을 임시 위치로 이동 
        hanoi(block - 1, one, three, two)
        print(one, three) # 마지막 블럭을 도착 위치로 이동
        # 임시 위치로 옮겼던 블럭을 다시 도착 위치로 옮기
        hanoi(block - 1, two, one, three)

n = int(input())
print(2 ** n - 1) 
hanoi(n, 1, 2, 3)
