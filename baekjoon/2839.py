n=int(input())

five = n//5
m = n % 5
three = m // 3
m = m % 3
while(m != 0 and (five >= 0)):
    five -= 1
    m += 5
    three = three + m // 3
    m = m % 3

if(five<0): print(-1)
else: print(five + three)
