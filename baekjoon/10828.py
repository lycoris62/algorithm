import sys
n = int(sys.stdin.readline())

class Stack:
    def __init__(self):
        self.li = []
    def push(self, x):
        self.li.append(x)
    def pop(self):
        if len(self.li) == 0:
            # return -1
            print('-1')
            return
        else:
            # return self.li.pop()
            print(self.li.pop())
    def size(self):
        # return len(self.li)
        print(len(self.li))
    def empty(self):
        # return 1 if len(self.li) == 0 else 0
        print(1 if len(self.li) == 0 else 0)
    def top(self):
        if len(self.li) == 0:
            # return -1
            print(-1)
        else:
            # return self.li[len(self.li) - 1]
            print(self.li[len(self.li) - 1])

st = Stack()

for _ in range(n):
    raw = sys.stdin.readline().split()
    strr = raw[0]
    if(strr == 'push'):
        st.push(int(raw[1]))
    elif(strr == 'pop'):
        st.pop()
    elif(strr == 'size'):
        st.size()
    elif(strr == 'empty'):
        st.empty()
    elif(strr == 'top'):
        st.top()
'''

li = []
for _ in range(n):
    raw = input().split()
    strr = raw[0]
    if(strr == 'push'):
        li.append(int(raw[1]))
    elif(strr == 'pop'):
        if len(li) == 0:
            print('-1')
        else:
            print(li.pop())
    elif(strr == 'size'):
        print(len(li))
    elif(strr == 'empty'):
        print(1 if len(li) == 0 else 0)
    elif(strr == 'top'):
        if len(li) == 0:
            print('-1')
        else:
            print(li[len(li) - 1])
'''
        
