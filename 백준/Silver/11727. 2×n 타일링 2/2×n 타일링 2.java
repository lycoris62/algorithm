import java.util.Scanner;

public class Main {

	static int N;
	static int[] dp;
	static final int OP = 10_007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[Math.max(N, 2) + 1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = 2 * dp[i - 2] + dp[i - 1];
			dp[i] %= OP;
		}

		System.out.println(dp[N]);
	}
}
