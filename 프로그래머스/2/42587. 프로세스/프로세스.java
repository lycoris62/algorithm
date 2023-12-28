import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int priority : priorities) {
            pq.add(priority);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}