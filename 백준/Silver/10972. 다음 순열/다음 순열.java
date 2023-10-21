import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = stoi(st.nextToken());
		}

		if (nextPermutation()) {
			for (int num : nums) {
				sb.append(num).append(" ");
			}
		} else {
			sb.append("-1");
		}

		System.out.println(sb);
	}

	static boolean nextPermutation() {
		int i = nums.length - 1;

		while (0 < i && nums[i] <= nums[i - 1])
			i--;

		// 내림차순
		if (i <= 0)
			return false;

		int j = nums.length - 1;

		while (nums[j] <= nums[i - 1])
			j--;

		int temp = nums[j];
		nums[j] = nums[i - 1];
		nums[i - 1] = temp;

		j = nums.length - 1;

		while (i < j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}

		return true;
	}
}
