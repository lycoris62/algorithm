import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // Map<String, Integer> 로 관리하기
        // 처음에는 keys()로 A, B 비교하다가, 둘이 같은 거 나오면 교집합과 합집합 각각 최소 최대 넣어주기
        // 말은 이렇게 했지만 어떻게 구현함?? 
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        // boolean isAlpha = Character.isAlphabetic(str1.charAt(1));
        // System.out.println(isAlpha);
        
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
        
        System.out.println(map1);
        System.out.println(map2);
        
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
                
        if (map1.isEmpty() || map2.isEmpty()) {
            return 0;
        }
        
        // 이중 key 포문으로 서로 겹치는 것 찾기 
        // 겹치는 게 있으면 두 value 비교해서 최솟값은 교집합수, 최댓값은 합집합수에 더하기
        
        // 아 둘이 안 겹치는 것들은 따로 합집합수에 넣어야 됨 

        
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
        
        System.out.println(min);
        System.out.println(max);
        
        return (int) Math.floor(min * 65536.0 / max);
    }
}