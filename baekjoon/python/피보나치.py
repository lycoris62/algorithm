def fib(i):
    arr = [None] * (i+1)
    arr[0] = 0
    arr[1] = 1
    for j in range(2, i+1):
        arr[j] = arr[j-1] + arr[j-2]
    print(arr[i])

fib(20)
