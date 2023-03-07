str = input()

num = 0

for idx, ch in enumerate(str):
    if(ch == '-'):
        continue
    elif(ch == 'j'):
        if((idx>0) and ((str[idx-1] == 'n') or (str[idx-1] == 'l'))):
            continue
    elif(ch == '='):
        if( (idx>1) and (str[idx-2] == 'd') and (str[idx-1] == 'z') ):
            num -= 1
            continue
        elif( (idx>0) and ( (str[idx-1] == 'c') or (str[idx-1] == 's') or (str[idx-1] == 'z') ) ):
            continue    
    num += 1

print(num)
