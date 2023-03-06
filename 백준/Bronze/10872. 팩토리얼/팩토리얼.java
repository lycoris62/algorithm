import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] * i;
        }
        System.out.println(dp[N]);
    }
}
