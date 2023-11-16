import java.util.*;

class Solution {
    public int[] solution(long n) {
        char[] chars = 
            new StringBuilder(String.valueOf(n))
            .reverse()
            .toString()
            .toCharArray();
        
        int[] answer = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            answer[i] = chars[i] - '0';
        }
        return answer;
    }
}