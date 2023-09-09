import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, K, res = Integer.MIN_VALUE;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = stoi(st.nextToken());
		}

		res = Arrays.stream(nums, 0, K).sum();

		slidingWindow();
		System.out.println(res);
	}

	static void slidingWindow() {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += nums[i];

			if (i - K >= 0) {
				sum -= nums[i - K];
				res = Math.max(res, sum);
			}
		}
	}
}

