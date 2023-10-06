import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int K;
	static int[] nums;
	static boolean[] visited;
	static int[] lotto = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			K = stoi(st.nextToken());

			if (K == 0)
				break;

			nums = new int[K];
			visited = new boolean[K];

			for (int i = 0; i < K; i++) {
				nums[i] = stoi(st.nextToken());
			}

			rec(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void rec(int depth, int start) {
		if (depth == 6) {
			for (int x : lotto) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lotto[depth] = nums[i];
				rec(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}

