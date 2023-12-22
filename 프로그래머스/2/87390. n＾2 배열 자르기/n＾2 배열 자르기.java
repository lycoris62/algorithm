import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int row = (int) ((i + left) / n); 
            int col = (int) ((i + left) % n); 
            
            answer[i] = Math.max(row + 1, col + 1);
        }
        
        return answer;
    }
}