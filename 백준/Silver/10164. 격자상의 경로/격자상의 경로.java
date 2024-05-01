import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K, answer;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        graph = new int[N][M];

        if (K == 0) {
            dfs(0, 0, N - 1, M - 1);
        } else {
            int mx = K / M;
            int my = K % M - 1;

            dfs(0, 0, mx, my);
            int temp = answer;
            answer = 0;
            dfs(mx, my, N - 1, M - 1);
            answer *= temp;
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int fx, int fy) {
        if (x == fx && y == fy) {
            answer++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
                dfs(nx, ny, fx, fy);
            }
        }
    }
}
