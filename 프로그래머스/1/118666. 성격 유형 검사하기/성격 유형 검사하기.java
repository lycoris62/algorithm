import java.util.*;

class Solution {
    
    int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
    Map<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < survey.length; i++) {
            String sur = survey[i];
            int choice = choices[i];
            
            if (choice == 4) continue;
            
            char ch = choice < 4 ? sur.charAt(0) : sur.charAt(1);
            map.put(ch, map.getOrDefault(ch, 0) + scores[choice]);
        }
        
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();
    }
}