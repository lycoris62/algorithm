import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Arrays.stream(queue1).forEach(x -> q1.add(x));
        Arrays.stream(queue2).forEach(x -> q2.add(x));
        
        int sum1 = Arrays.stream(queue1).sum();
        int sum2 = Arrays.stream(queue2).sum();
        
        
        
        return answer;
    }
}