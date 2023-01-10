"""
    2309 일곱 난쟁이
    https://www.acmicpc.net/problem/2309
"""

from itertools import permutations

li = [ int(input()) for _ in range(9) ] # 9명의 난쟁이를 입력받아 리스트로 만드는 리스트 컴프리헨션
# 순열(permutations) 을 사용하여, 9요소의 리스트 중 7개를 뽑는 경우의 수 중에서,
for item in permutations(li, 7):
    if sum(item) == 100: # 합이 100이 되면,
        for x in sorted(list(item)): # 그 7 요소를 한줄에 하나씩 출력
            print(x)
        break

# # 순열 안 쓰기
# li = [ int(input()) for _ in range(9) ]
# li.sort()
# total = sum(li)
#
# def main():
#     for i in range(8):
#         for j in range(i + 1, 9):
#             if total - li[i] - li[j] == 100:
#                 for k in range(9):
#                     if i != k and j != k:
#                         print(li[k])
#                 return
# main()


"""
20
7
23
19
10
15
25
8
13

"""