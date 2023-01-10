j = int(input())
arr = []
for _ in range(j):
	arr.append(list(map(int, input().split())))

def getRoomNum(arr):
    h, w, n = arr
    i = 0
    maxNum = h
    while(maxNum < n):
        i += 1
        maxNum += h
    yy = h - (maxNum - n)
    xx = i + 1
    if(xx<10):
        xx = '0' + str(xx)
    else:
        xx = str(xx)
    print(str(yy) + xx)

for ar in arr:
    getRoomNum(ar)
