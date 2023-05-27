import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < N; i++) {
            if (i * 3 <= N) {
                dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
            if (i * 2 <= N) {
                dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            }
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}