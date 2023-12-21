import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.substring(i, i + 1));
        }
        
        for (int i = 0; i < s.length(); i++) {
            q.add(q.poll());
            Stack<String> st = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                String next = q.poll();
                q.add(next);
                
                if (st.isEmpty()) {
                    st.push(next);
                } else if (
                    next.equals(")") && st.peek().equals("(")
                    || next.equals("]") && st.peek().equals("[")
                    || next.equals("}") && st.peek().equals("{") ) {
                    
                    st.pop();
                } else {
                    st.push(next);
                }
            }
            
            if (st.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}