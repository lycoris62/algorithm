import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            N = stoi(br.readLine());
            dp = new int[Math.max(N + 1, 4)];

            dp[1] = 1; // 1
            dp[2] = 2; // 1 + 1, 2
            dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3 (순서에 따라 다름)

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
