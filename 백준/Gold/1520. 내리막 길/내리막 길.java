import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] graph;
    static Integer[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        graph = new int[N][M];
        dp = new Integer[N][M];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        System.out.println(dp(N - 1, M - 1));
    }

    static int dp(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return 0;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[x][y] < graph[nx][ny])) {
                dp[x][y] += dp(nx, ny);
            }
        }

        return dp[x][y];
    }
}
