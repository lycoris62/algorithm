import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int OP = 10_007;
    static int N;
    static String S;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = S.length();

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            dp[i - 1][i] = 2;
            if (S.charAt(i) == S.charAt(i - 1)) {
                dp[i - 1][i]++;
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = i; j < N; j++) {
                dp[j - i][j] = dp[j - i][j - 1] + dp[j - i + 1][j];
                dp[j - i][j] += S.charAt(j) == S.charAt(j - i) ? 1 : OP - dp[j - i + 1][j - 1];
                dp[j - i][j] %= OP;
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
