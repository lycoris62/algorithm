import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n) {
        int[] visited = new int[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if (now == y) return visited[now] - 1;
            
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now + n;
                else if (i == 1) next = now * 2;
                else next = now * 3;
                
                if (0 <= next && next <= y && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}