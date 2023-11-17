import java.util.stream.*;

class Solution {
    public long solution(int a, int b) {
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).reduce(0L, Long::sum);
    }
}