import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] nums = new int[N];
		int[] dp = new int[N];

		IntStream.range(0, N).forEach(i -> nums[i] = sc.nextInt());

		for (int std = 0; std < N; std++) {
			for (int i = 0; i < std; i++) {
				if (nums[i] < nums[std] && dp[std] < dp[i]) {
					dp[std] = dp[i];
				}
			}

			dp[std] += nums[std];
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
