import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            
            if (word.equals(" ")) {
                answer.append(" ");
                continue;
            }
            
            char ch = word.charAt(0);
            if ('0' <= ch && ch <= '9') {
                answer.append(word);
                continue;
            }
            
            String newWord = (char) (word.charAt(0) + 'A' - 'a') + word.substring(1);
            answer.append(newWord);
        }
        
        return answer.toString();
    }
}