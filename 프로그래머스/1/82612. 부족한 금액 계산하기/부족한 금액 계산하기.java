import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        
        long total = LongStream.rangeClosed(1, count)
            .reduce(money, (sum, cnt) -> sum -= (price * cnt));
        
        return total > 0 ? 0 : -total;
    }
}