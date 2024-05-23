import java.util.*;

class Solution {
    
    Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                int time = i - idx;
                answer[idx] = time;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int time = prices.length - 1 - idx;
            answer[idx] = time;
        }
        
        return answer;
    }
}