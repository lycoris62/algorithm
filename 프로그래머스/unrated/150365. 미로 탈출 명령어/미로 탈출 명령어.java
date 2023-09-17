import java.util.*;

class Solution {
    
    char[] dir = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int N, M, R, C;
    String res;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        N = n;
        M = m;
        R = r - 1;
        C = c - 1;
        
        boolean isRunnable = dfs(x-1, y-1, k, "", Math.abs(x-r) + Math.abs(y-c));
        
        return isRunnable ? res : "impossible";
    }
    
    public boolean dfs(int x, int y, int k, String str, int dist) {
        if (k == 0 && dist == 0) {
            res = str; 
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (dist <= k)) {
                if ((k % 2 == 0 && dist % 2 == 0) || (k % 2 == 1 && dist % 2 == 1)) {
                    if (dfs(nx, ny, k - 1, str + dir[i], Math.abs(nx - R) + Math.abs(ny - C))) 
                        return true;
                }
            }
        }
        
        return false;
    }
}