"""
    과제 안 내신 분..? (Bronze 5)
    https://www.acmicpc.net/problem/5597
"""
li = list(range(1, 31)) # 학생 번호 1~30번

for _ in range(28): # 28명만 과제를 냄 
    x = int(input())
    li.remove(x) # 28명은 리스트에서 제거 

for x in li: # 남은 2명 공개처형 
    print(x)

"""
3
1
4
5
7
9
6
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30

9
30
6
12
10
20
21
11
7
5
28
4
18
29
17
19
27
13
16
26
14
23
22
15
3
1
24
25

"""