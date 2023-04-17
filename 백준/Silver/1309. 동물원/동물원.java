import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    final static int OP = 9901;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        dp = new int[N + 1][3];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];

            for (int j = 0; j < 3; j++) dp[i][j] %= OP;
        }
        System.out.println(Arrays.stream(dp[N]).sum() % OP);
    }
}
