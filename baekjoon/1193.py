n = int(input())
'''
1 3 4 10 11 21 22 37 38
2 6 10 15

2 (1)
3 (2)*
4 (3)
5 (4)*
6 (5)
7 (6)*
8 (7)
9 (8)*

1, 2, 7, 16, 29, ...
 4, 11, 22, 38, ...
1, 6, 15, 28, ...
'''
 
lineNum = 1
maxNum = 1
i = 1

if(n == 1): print('1/1')
else:
    while(maxNum < n):
        lineNum += 2
        maxNum += ( ( i + 1 ) + ( i + 2 ) )
        i += 2
    #지금 2~6
    if(n <= ( maxNum - i ) ):
        i -= 1
        lineNum -= 1
        j = maxNum - (i + 1) - n
        num = lineNum - j
        den = 1 + j
        print(str(num) + '/' + str(den))
    else:
        j = maxNum - n
        num = 1 + j
        den = lineNum - j
        print(str(num) + '/' + str(den))
        
        
        


