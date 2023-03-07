n = int(input())

num = 1

#1, 7, 19, 37, 61, ~
# +6 +12 +18 +24

max_num = 1
i = 1
while(max_num < n):
    num += 1
    max_num += (6 * i)
    i += 1
print(num)
