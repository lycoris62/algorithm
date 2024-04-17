import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i + 2);
            
            if (!Character.isAlphabetic(word.charAt(0))
               || !Character.isAlphabetic(word.charAt(1))) {
                continue;   
            }
            
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i + 2);
            
            if (!Character.isAlphabetic(word.charAt(0))
               || !Character.isAlphabetic(word.charAt(1))) {
                continue;   
            }
            
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
                
        if (map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }

        int min = 0;
        int max = 0;
        
        for (String key2 : map2.keySet()) {
            if (!map1.containsKey(key2)) {
                max += map2.get(key2);
            }
        }
        
        for (String key1 : map1.keySet()) {
            if (!map2.containsKey(key1)) {
                max += map1.get(key1);        
            }
            
            for (String key2 : map2.keySet()) {
                if (!key1.equals(key2)) {
                    continue;
                }
                
                int val1 = map1.get(key1);
                int val2 = map2.get(key2);
                
                min += Math.min(val1, val2);
                max += Math.max(val1, val2);
            }
        }
        
        return (int) Math.floor(min * 65536.0 / max);
    }
}