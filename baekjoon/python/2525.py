h,m = map(int, input().split())
t = int(input())

min_time = (h * 60 + m + t) % ( 24 * 60 )
fh = int(min_time / 60)
fm = int(min_time % 60)

print(str(fh)+' '+str(fm))
