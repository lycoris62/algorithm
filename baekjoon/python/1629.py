a, b, c = map(int, input().split())

def multi(a, n):
    if n == 1:
        return a % c
    else:
        temp = multi(a, n // 2)

        if n % 2 == 0:
            return ( temp * temp ) % c
        else:
            return ( temp * temp * a ) % c

print(multi(a, b))
