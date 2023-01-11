"""
    쉬운 계단수 (Silver 1)
    https://www.acmicpc.net/problem/10844
"""

MOD = 1_000_000_000
# cache[n][d] = 길이가 n, 마지막 숫자가 d인 계단수 개수
cache = [[0] * 10 for _ in range(101)]  # n은 1~100 이므로 101개를 만들고, d는 0~9까지니까 10개를 만든다.
for d in range(1, 10): # cache[1][0] 은 0으로 시작하므로 문제 조건에 따라 0이다.
    cache[1][d] = 1 # 길이가 1이고 자릿수가 0이 아니면 초기값은 1이다.

for N in range(2, 101): # 길이 N이 2~100 이고
    for D in range(10): # 자릿수 D가 0~9일 때를 반복
        if D > 0: # 자릿수가 1~9이면 이전 길이의 전 자릿수의 계단수 개수를 더하고,
            cache[N][D] += cache[N - 1][D - 1]
            cache[N][D] %= MOD

        if D < 9: # 자릿수가 0~8이면 이전 길이의 후 자릿수의 계단수 개수를 더한다.
            cache[N][D] += cache[N - 1][D + 1]
            cache[N][D] %= MOD

        # 따라서 최종적으로 d=0이면 이후 자릿수만, d=9이면 이전 자릿수만, d=1~8이면 전,후 자릿수를 다 더하게 된다.

ans = 0
n = int(input())
for d in range(10):
    ans += cache[n][d]
    ans %= MOD

print(ans)

"""
1

2

"""

"""
# 2022.11.22 때 풀었던 코드 
n = int(input())

arr = [ [0] * 10 for _ in range(n+1) ]

for number in range(1, 10): # number는 0부터 9까지.
    # 1번째 자릿수(제일 높은 수)의 1부터 9까지는 1로 저장, 0은 앞에 올 수 없으니 0으로 저장.  
    arr[1][number] = 1 

for digit in range(2, n+1): # 2번째 자릿수부터 n번째 자릿수(1의 자리)까지 반복. 
    for number in range(10): # 각 자릿수에서 0부터 9까지 반복 
        if number == 0: # 0의 계단수는 이전 자릿수(10배한 자릿수)의 1밖에 없다. 
            arr[digit][number] = arr[digit-1][1]
        elif number == 9: # 9의 계단수는 이전 자릿수의 8밖에 없다. 
            arr[digit][number] = arr[digit-1][8]
        else: # 나머지인 1~8의 계단수는 이전 자릿수의 전후의 합과 같다. 
            arr[digit][number] = arr[digit-1][number-1] + arr[digit-1][number+1]
print(arr)
print(sum(arr[n]) % 1000000000)
"""
