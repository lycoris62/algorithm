import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static Item[] items;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dp = new Integer[N][K + 1];
        items = new Item[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        System.out.println(dp(N - 1, K));
    }

    static int dp(int i, int maxWeight) {
        if (maxWeight <= 0 || i < 0) {
            return 0;
        }

        if (dp[i][maxWeight] != null) {
            return dp[i][maxWeight];
        }

        Item item = items[i];

        if (item.weight > maxWeight) {
            return dp[i][maxWeight] = dp(i - 1, maxWeight);
        }

        return dp[i][maxWeight] = Math.max(dp(i - 1, maxWeight), dp(i - 1, maxWeight - item.weight) + item.value);
    }

    static class Item {

        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
