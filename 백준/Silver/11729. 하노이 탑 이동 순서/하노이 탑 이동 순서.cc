#include <iostream>

using namespace std;

void hanoi(int n, int from, int temp, int to) {
    if (n == 1)
        printf("%d %d\n", from, to);
    else {
        hanoi(n - 1, from, to, temp);
        printf("%d %d\n", from, to);
        hanoi(n - 1, temp, from, to);
    }
}

int main() {
    int n;
    cin >> n;
    cout << (1 << n) - 1 << "\n";
    hanoi(n, 1, 2, 3);
    return 0;
}
