import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> st = new Stack<>();
        
        for (int move : moves) {
            int character = 0;
            for (int i = 0; i < N; i++) {
                if (board[i][move - 1] != 0) {
                    character = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            
            if (character == 0) continue;
            
            boolean isPop = false;
            while (!st.isEmpty() && st.peek() == character) {
                answer++;
                st.pop();
                isPop = true;
            }
            
            if (!isPop) st.push(character);
            
        }
        return answer * 2;
    }
}