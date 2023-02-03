str = input()
bombs = input()
stack = list()
bombs_length = len(bombs)

for char in str:
    stack.append(char)
    if char == bombs[-1] and "".join(stack[-bombs_length:]) == bombs:
        del stack[-bombs_length:]

print("".join(stack) if len(stack) != 0 else "FRULA")


"""
mirkovC4nizCC44
C4

12ab112ab2ab
12ab

"""