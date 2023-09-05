import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, res;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, i, j, graph[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(res);
    }

    static void dfs(int depth, int x, int y, int sum) {
        if (depth == 4) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny])) {
                if (depth == 2) {
                    visited[nx][ny] = true;
                    dfs(depth + 1, x, y, sum + graph[nx][ny]);
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                dfs(depth + 1, nx, ny, sum + graph[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}

