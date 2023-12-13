import java.util.stream.*;

class Solution {
    public int solution(int number, int limit, int power) {
        return IntStream.rangeClosed(1, number)
            .map(i -> getIronWeight(i, limit, power))
            .sum();
    }
    
    private int getIronWeight(int num, int limit, int power) {
        int totalIron = 0; 
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                totalIron++;
                if (num / i != i) {
                    totalIron++;
                }
            }
            
            if (totalIron > limit) {
                return power;
            }
        }
        
        return totalIron;
    }
}