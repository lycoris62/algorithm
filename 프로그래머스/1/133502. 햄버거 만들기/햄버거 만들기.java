import java.util.*;

class Solution {
    
    Stack<Integer> st = new Stack<>();
    
    public int solution(int[] ingredient) {
        int answer = 0;
        
        for (int x : ingredient) {
            st.push(x);
            
            if (st.size() >= 4 && st.peek() == 1) {
                if (isHamburger()) {
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private boolean isHamburger() {
        return st.get(st.size() - 1) == 1
            && st.get(st.size() - 2) == 3
            && st.get(st.size() - 3) == 2
            && st.get(st.size() - 4) == 1;
    }
}