import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M;
	static long[] nums, tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		nums = new long[N + 1];
		tree = new long[4 * N];

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int order = stoi(st.nextToken());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());

			if (order == 0) {
				int left = Math.min(x, y);
				int right = Math.max(x, y);
				long sum = sum(1, N, 1, left, right);
				sb.append(sum).append("\n");
			} else {
				nums[x] = y;
				update(1, N, 1, x, y);
			}
		}

		System.out.println(sb);
	}

	static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = nums[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	static long sum(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	static long update(int start, int end, int node, int index, int value) {
		if (index < start || end < index) {
			return tree[node];
		}
		if (start == end) {
			return tree[node] = value;
		}

		int mid = (start + end) / 2;
		return tree[node] =
			update(start, mid, node * 2, index, value) + update(mid + 1, end, node * 2 + 1, index, value);
	}
}
