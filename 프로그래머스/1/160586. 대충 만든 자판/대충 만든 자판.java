import java.util.*;

class Solution {
    
    Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                map.put(ch, Math.min(i + 1, map.getOrDefault(ch, Integer.MAX_VALUE)));
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            
            for (char ch : target.toCharArray()) {
                if (!map.containsKey(ch)) {
                    cnt = -1;
                    break;
                }
                cnt += map.get(ch);
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}