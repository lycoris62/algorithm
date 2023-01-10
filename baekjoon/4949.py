def checkRL(st):
    smcnt = 0
    lrcnt = 0
    li = list(filter(lambda x: x=='(' or x==')' or x == '[' or x == ']', st))
    lastLeft = []
    if len(li) == 0:
        print("yes")
        return
    for c in li:
        if c == '(':
            smcnt += 1
            lastLeft.append('(')
        elif c == '[':
            lrcnt += 1
            lastLeft.append('[')
        elif c == ')':
            smcnt -= 1
            if smcnt < 0 or lastLeft.pop() != '(':
                print("no")
                return
        elif c == ']':
            lrcnt -= 1
            if lrcnt < 0 or lastLeft.pop() != '[':
                print("no")
                return
    if smcnt == 0 and lrcnt == 0:
        print("yes")
    else:
        print("no")
    return

while(True):
    strr = input()
    if strr == '.':
        break
    checkRL(strr)
    
'''
for c in li:
        if c == '(':
            smcnt += 1
        elif c == ')':
            smcnt -= 1
            if smcnt < 0:
                print("no")
                return
        if c == '[':
            lrcnt += 1
        elif c == ']':
            lrcnt -= 1
            if lrcnt < 0:
                print("no")
                return
    if smcnt == 0 and lrcnt == 0:
        print("yes")
    else:
        print("no")
    return
'''
