#include <iostream>
// 9012

using namespace std;

void sol(const string& str) {
    int cnt = 0;
    for (char x : str) {
        if (x == '(') {
            cnt++;
        } else {
            if (cnt == 0) {
                printf("NO\n");
                return;
            } else {
                cnt--;
            }
        }
    }

    cnt == 0 ? printf("YES\n") : printf("NO\n");
}

int main() {
    int n;
    cin >> n;
    while (n-- > 0) {
        string str;
        cin >> str;
        sol(str);
    }
}