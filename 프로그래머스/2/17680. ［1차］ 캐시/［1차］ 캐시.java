import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        Queue<String> cache = new ArrayDeque<>(cacheSize);
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.remove(city)) {
                totalTime += 1;
                cache.add(city);
                continue;
            }
            
            if (cache.size() >= cacheSize) {
                cache.poll();
            }
            totalTime += 5;
            cache.add(city);
        }
        
        return totalTime;
    }
}