import java.io.*;
import java.util.*;

public class Main {
    static int N, MOD = 1000000;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        N = str.length();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = str.charAt(i - 1) - '0';
        }

        dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int oneDigit = arr[i];
            if (1 <= oneDigit && oneDigit <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if (i == 1 || arr[i - 1] == 0) continue;
            int twoDigit = arr[i - 1] * 10 + arr[i];
            if (10 <= twoDigit && twoDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
