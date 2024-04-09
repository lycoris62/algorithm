import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new ArrayDeque<>(cacheSize);
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (q.contains(city)) {
                answer += 1;
                q.remove(city);
                q.add(city);
                continue;
            }

            if (q.size() >= cacheSize) {
                q.poll();
            }
            answer += 5;
            q.add(city);
        }
        
        return answer;
    }
}