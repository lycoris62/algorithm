import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(List.of(s1));
        for (String x : s2) set.add(x);
        
        return s1.length + s2.length - set.size();
    }
}