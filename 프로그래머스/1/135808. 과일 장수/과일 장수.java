import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : score) pq.add(x);
        
        while (!pq.isEmpty() && pq.size() >= m) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                int pop = pq.poll();
                min = Math.min(min, pop);
            }
            
            answer += min * m;
        }
        
        return answer;
    }
}