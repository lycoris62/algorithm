import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    int bfs(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (maps[nx][ny] == 1)) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }
        
        return -1;
    }
    
    class Node {
        int x, y, cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}