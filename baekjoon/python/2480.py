ar = list(map(int, input().split()))
arr = list(set(ar))

def getTwoNum(ar):
    if(ar[0] == ar[1] or ar[0] == ar[2]):
        return ar[0]
    else:
        return ar[1]

if(len(arr) == 1):
    print(10000 + arr[0] * 1000)
elif(len(arr) == 3):
    print(100 * max(arr))
else:
    print(1000 + getTwoNum(ar) * 100)
