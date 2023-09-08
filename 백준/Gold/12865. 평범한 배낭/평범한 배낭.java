import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, K;
	static Integer[][] dp;
	static Item[] items;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		dp = new Integer[N][K + 1];
		items = new Item[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			items[i] = new Item(stoi(st.nextToken()), stoi(st.nextToken()));
		}

		System.out.println(knapsack(N - 1, K));
	}

	static int knapsack(int n, int k) {
		if (k <= 0 || n < 0)
			return 0;
		if (dp[n][k] != null)
			return dp[n][k];

		Item item = items[n];

		if (item.weight > k) {
			return dp[n][k] = knapsack(n - 1, k);
		} else {
			return dp[n][k] = Math.max(item.value + knapsack(n - 1, k - item.weight), knapsack(n - 1, k));
		}
	}

	static class Item {
		int weight, value;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
