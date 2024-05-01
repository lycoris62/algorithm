import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        dp[0][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if (K == 0) {
            System.out.println(dp[N][M]);
        } else {
            int ax = K / M + (K % M > 0 ? 1 : 0);
            int ay = K - (ax - 1) * M;

            int bx = N - ax + 1;
            int by = M - ay + 1;

            System.out.println(dp[ax][ay] * dp[bx][by]);
        }
    }
}
