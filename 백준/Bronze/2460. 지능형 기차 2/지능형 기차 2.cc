#include <iostream>
using namespace std;

int main() {
	int res = 0;
	int num = 0;
	int out, in;
	for(int i=0;i < 10; i++) {
		cin >> out >> in;
		num = num - out + in;
		res = max(num, res);
	}
	cout << res << endl;
	return 0;
}