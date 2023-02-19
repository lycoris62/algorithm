import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static int N;
    static int K;
    static int[][] dp;
    static int op = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        dp = new int[K+1][N+1];

        for (int i = 0; i <= N; i++) dp[1][i] = 1;
        for (int i = 1; i <= K; i++) dp[i][0] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % op;
            }
        }

        System.out.println(dp[K][N]);
    }
}
