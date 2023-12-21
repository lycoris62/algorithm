import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int kind : tangerine) {
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        
        for (int value : values) {
            answer++;
            k -= value;
            
            if (k <= 0) 
                break;
        }
        
        return answer;
    }
}