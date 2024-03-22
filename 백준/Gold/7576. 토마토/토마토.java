import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int M, N;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = stoi(st.nextToken());
                graph[i][j] = x;
                if (x == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, graph[i][j]);
            }
        }

        System.out.println(ans - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Tomato now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == 0)) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[now.x][now.y] + 1;
                    q.add(new Tomato(nx, ny));
                }
            }
        }
    }

    static class Tomato {

        int x, y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
