import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, K;
	static int[] dp;
	static int NONE = Integer.MAX_VALUE / 2;
	static List<Integer> coins = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		dp = new int[K + 1];

		for (int i = 0; i < N; i++) {
			int x = stoi(br.readLine());
			if (!coins.contains(x)) {
				coins.add(x);
			}
		}

		Collections.sort(coins);
		Arrays.fill(dp, NONE);
		dp[0] = 0;

		for (Integer coin : coins) {
			for (int i = coin; i <= K; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		int answer = dp[K] == NONE ? -1 : dp[K];
		System.out.println(answer);
	}
}
