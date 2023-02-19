import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int K;
    static List<Integer[]> list;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        list = new ArrayList<>(N);
        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Integer[]{stoi(st.nextToken()), stoi(st.nextToken())});
        }

        System.out.println(knapsack(N - 1, K));
    }

    static int knapsack(int i, int k) {
        if (i < 0) return 0;
        if (dp[i][k] == null) {
            Integer[] integers = list.get(i);
            int weight = integers[0];
            int value = integers[1];

            if (weight > k) {
                dp[i][k] = knapsack(i - 1, k);
            } else {
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - weight) + value);
            }
        }
        return dp[i][k];
    }
}