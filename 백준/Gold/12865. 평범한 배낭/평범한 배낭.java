import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int[] V, W;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dp = new Integer[N][K + 1];
        V = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = stoi(st.nextToken());
            V[i] = stoi(st.nextToken());
        }

        System.out.println(dp(N - 1, K));
    }

    static int dp(int i, int k) {
        if (i < 0 || k <= 0) {
            return 0;
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        return dp[i][k] = k - W[i] >= 0
                ? Math.max(dp(i - 1, k - W[i]) + V[i], dp(i - 1, k))
                : dp(i - 1, k);
    }
}
