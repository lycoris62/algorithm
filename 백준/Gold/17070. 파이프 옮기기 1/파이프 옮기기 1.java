import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] graph;
	static int[][][] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		dp[1][2][0] = 1;
		dp();

		int result = Arrays.stream(dp[N][N]).sum();
		System.out.println(result);
	}

	static void dp() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1)
					continue;

				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
				dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];

				if (graph[i - 1][j] == 0 && graph[i][j - 1] == 0)
					dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
	}
}
