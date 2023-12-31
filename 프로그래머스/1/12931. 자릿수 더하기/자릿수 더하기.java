public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (true) {
            answer += n % 10;
            
            if (n < 10) break;
            
            n /= 10;
        }
        
        return answer;
    }
}