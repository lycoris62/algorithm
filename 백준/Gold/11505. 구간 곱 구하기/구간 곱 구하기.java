import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M, K;
	static long[] nums, tree;
	static final long INF = Long.MAX_VALUE / 2;
	static final long OP = 1_000_000_007;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());

		nums = new long[N + 1];
		tree = new long[4 * N];
		nums[0] = tree[0] = INF;

		for (int i = 1; i <= N; i++) {
			nums[i] = stoi(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());

			if (a == 1) {
				nums[b] = c;
				update(1, N, 1, b, c);
			} else {
				long x = get(1, N, 1, b, c);
				sb.append(x).append("\n");
			}
		}

		System.out.println(sb);
	}

	static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = nums[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % OP;
	}

	static long update(int start, int end, int node, int index, int after) {
		if (index < start || end < index) {
			return tree[node]; // 변경되는 부분이랑 관련없는 범위는 그대로 두기.
		}

		if (start == end) {
			return tree[node] = after; // 변경하고자 하는 인덱스의 트리값 수정
		}

		int mid = (start + end) / 2;
		// 이후로 변경에 영향받는 노드들 다시 계산해줌
		return tree[node] =
			(update(start, mid, node * 2, index, after) * update(mid + 1, end, node * 2 + 1, index, after)) % OP;
	}

	static long get(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return 1;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return get(start, mid, node * 2, left, right) * get(mid + 1, end, node * 2 + 1, left, right) % OP;
	}
}
