import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        
        long total = money;
        
        for (int i = 1; i <= count; i++) {
            total -= price * i;    
        }
        
        return -total < 0 ? 0 : -total;
        
        // return LongStream.rangeClosed(1, count)
        //     .reduce(-money, (sum, cnt) -> sum += (price * cnt));
    }
}