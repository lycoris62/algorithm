import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        
        String prev = words[0];
        set.add(prev);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            
            if (prev.charAt(prev.length() - 1) != word.charAt(0) || set.contains(word)) {
                return new int[] {(i % n) + 1, i / n + 1};
            }
            
            set.add(word);
            prev = word;
        }

        return new int[] {0, 0};
    }
}