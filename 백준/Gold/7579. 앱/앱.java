import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] memories, costs;
    static int[][] dp;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        memories = new int[N];
        costs = new int[N];
        dp = new int[N][100 * N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = stoi(st.nextToken());
        }

        knapsack();

        System.out.println(answer);
    }

    private static void knapsack() {
        for (int appIndex = 0; appIndex < N; appIndex++) {
            for (int nowCost = 0; nowCost <= 100 * N; nowCost++) {
                if (appIndex == 0) {
                    if (nowCost - costs[appIndex] >= 0) {
                        dp[appIndex][nowCost] = memories[appIndex];
                    }
                } else {
                    dp[appIndex][nowCost] = nowCost - costs[appIndex] >= 0
                            ? Math.max(dp[appIndex - 1][nowCost - costs[appIndex]] + memories[appIndex], dp[appIndex - 1][nowCost])
                            : dp[appIndex - 1][nowCost];
                }

                if (dp[appIndex][nowCost] >= M) {
                    answer = Math.min(answer, nowCost);
                }
            }
        }
    }
}
