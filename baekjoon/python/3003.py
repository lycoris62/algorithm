std = [1,1,2,2,2,8]
li = list(map(int, input().split()))
ans = [ str(std[i] - li[i]) for i in range(len(std)) ]
print(' '.join(ans))
