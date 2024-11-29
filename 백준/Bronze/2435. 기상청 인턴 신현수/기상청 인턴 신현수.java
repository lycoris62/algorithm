import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer = Integer.MIN_VALUE;
    static int[] arr, dp;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = K - 1; i < N; i++) {
            answer = Math.max(dp[i] - dp[i - K + 1] + arr[i - K + 1], answer);
        }

        System.out.println(answer);
    }
}
