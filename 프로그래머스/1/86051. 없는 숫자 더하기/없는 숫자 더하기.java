import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int nowNumber = 0;
        int idx = 0;
        
        Arrays.sort(numbers);
        
        while (nowNumber < 10) {
            if (idx < numbers.length && nowNumber >= numbers[idx]) {
                idx++;
                nowNumber++;
                continue;
            }
            
            answer += nowNumber;
            nowNumber++;
        }
        
        
        
        
        return answer;
    }
}