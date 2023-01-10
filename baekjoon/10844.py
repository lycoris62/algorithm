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
