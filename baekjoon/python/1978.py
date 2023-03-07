n = int(input())
arr = list(map(int, input().split()))
remove_set = {1}
arr = [i for i in arr if i not in remove_set]

def isPrime(num):
    for i in range(2, num):
        if( num % i == 0): return 0
    return 1
res = 0

for ar in arr:
    res += isPrime(ar)
print(res)
