import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Arrays.stream(queue1).forEach(x -> q1.add(x));
        Arrays.stream(queue2).forEach(x -> q2.add(x));
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        while(true) {
            if (answer > 2 * (queue1.length + queue2.length) + 1) {
                return -1;
            }
            if (sum1 == sum2) {
                break;
            }
            
            if (sum1 > sum2) {
                int pop = q1.poll();
                q2.add(pop);
                sum1 -= pop;
                sum2 += pop;
            } else {
                int pop = q2.poll();
                q1.add(pop);
                sum1 += pop;
                sum2 -= pop;
            }
            answer++;
        }
        
        return answer;
    }
}