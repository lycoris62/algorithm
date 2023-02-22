import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] dp;
    static int op = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        dp = new int[N][10];
        
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= op;
                }
            }
        }

        System.out.println(Arrays.stream(dp[N - 1]).sum() % op);
    }
}
