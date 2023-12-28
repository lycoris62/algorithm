import java.util.*;

class Solution {
    
    List<Integer> answer = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil(( 100.0 - progresses[i]) / speeds[i]);
            q.add(days);
        }
        
        while (!q.isEmpty()) {
            int minDays = q.poll();
            int cnt = 1;
            
            while (!q.isEmpty() && q.peek() <= minDays) {
                q.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}