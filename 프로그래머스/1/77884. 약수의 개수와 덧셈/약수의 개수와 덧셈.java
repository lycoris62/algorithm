import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
            .reduce(0, (total, i) -> total += (getCount(i) % 2 == 0 ? 1 : -1) * i);
    }
    
    private int getCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}