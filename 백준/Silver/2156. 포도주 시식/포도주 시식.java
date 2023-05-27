import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] wines;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        wines = new int[N + 1];
        dp = new Integer[N + 1];
        for (int i = 0; i < N; i++) {
            wines[i + 1] = stoi(br.readLine());
        }

        dp[0] = 0;
        dp[1] = wines[1];

        if (N > 1) {
            dp[2] = wines[1] + wines[2];
        }
        System.out.println(recur(N));
    }

    static int recur(int n) {
        if (dp[n] == null) {
            int nowMax = wines[n] + Math.max(recur(n - 2), wines[n - 1] + recur(n - 3));
            dp[n] = Math.max(nowMax, recur(n - 1));
        }

        return dp[n];
    }
}
