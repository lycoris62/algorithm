import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] T, P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = stoi(st.nextToken());
            P[i] = stoi(st.nextToken());
        }

        int maxIncome = 0;

        for (int i = 1; i <= N; i++) {
            maxIncome = Math.max(maxIncome, dp[i]);
            int nextDay = i + T[i];
            
            if (nextDay <= N + 1) {
                dp[nextDay] = Math.max(dp[nextDay], maxIncome + P[i]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
