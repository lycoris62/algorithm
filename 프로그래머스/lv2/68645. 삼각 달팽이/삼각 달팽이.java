import java.util.*;

class Solution {
    
    static final int[] dx = {1, 0, -1};
    static final int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        int x = 0;
        int y = 0;
        int d = 0;
        int cnt = 1;
        
        while(true) {
            arr[x][y] = cnt++;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || n <= nx || ny < 0 || n <= ny || arr[nx][ny] != 0) {
                
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                
                if (nx < 0 || n <= nx || ny < 0 || n <= ny || arr[nx][ny] != 0) {
                    break;
                } 
            } 
            
            x = nx;
            y = ny;
        }
        
        int idx = 0;
        int[] answer = new int[cnt - 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}