import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push("(");
                continue;
            }
            
            if (stack.isEmpty()) {
                answer = false;
                break;
            }
            
            stack.pop();
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}