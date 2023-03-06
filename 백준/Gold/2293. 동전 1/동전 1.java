import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int K;
    static List<Integer> coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        coins = new ArrayList<>(N);
        dp = new int[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) coins.add(stoi(br.readLine()));

        for (int i = 0; i < N; i++) {
            for (int j = coins.get(i); j <= K; j++) {
                dp[j] += dp[j - coins.get(i)];
            }
        }

        System.out.println(dp[K]);
    }
}