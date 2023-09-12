import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M;
	static int[] nums, tree;
	static final int INF = Integer.MAX_VALUE / 2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		nums = new int[N + 1];
		tree = new int[4 * N];
		tree[0] = nums[0] = INF;

		for (int i = 1; i <= N; i++) {
			nums[i] = stoi(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());

			int min = min(1, N, 1, a, b);
			sb.append(min).append("\n");
		}

		System.out.println(sb);
	}

	static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = nums[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}

	static int min(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return tree[0];
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
	}
}
