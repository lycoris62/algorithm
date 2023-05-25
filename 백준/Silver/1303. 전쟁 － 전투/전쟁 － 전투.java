import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, W = 0, B = 0;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, graph[i][j]);
                }
            }
        }
        
        System.out.printf("%d %d\n", W, B);
    }

    static void bfs(int ox, int oy, char team) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ox, oy});
        visited[ox][oy] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == team)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (team == 'W') {
            W += cnt * cnt;
        } else {
            B += cnt * cnt;
        }
    }
}
