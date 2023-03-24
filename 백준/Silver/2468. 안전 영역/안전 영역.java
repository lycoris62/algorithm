import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, max = Integer.MIN_VALUE, min = 0, res = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                int x = stoi(st.nextToken());
                map[i][j] = x;
                max = Math.max(max, x);
            }
        }

        while (min <= max) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > min) {
                        cnt++;
                        bfs(i, j, min, visited);
                    }
                }
            }
            res = Math.max(res, cnt);
            min++;
        }

        System.out.println(res);
    }

    static void bfs(int n, int m, int height, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, m});
        visited[n][m] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && map[nx][ny] > height) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
