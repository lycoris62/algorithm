N: int = int(input())

count: int = 0
total: int = 0

start: int = 0
end: int = 0

while end <= N:
    if total < N:
        end += 1
        total += end
    elif total > N:
        total -= start
        start += 1
    else:
        count += 1
        end += 1
        total += end

print(count)
