import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M;
	static int[] nums;
	static Node[] tree;
	static final int INF = Integer.MAX_VALUE / 2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		nums = new int[N + 1];
		tree = new Node[4 * N];
		nums[0] = INF;
		tree[0] = new Node(INF, -INF);

		for (int i = 1; i <= N; i++) {
			nums[i] = stoi(br.readLine());
		}

		init(1, N, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());

			Node node = minmax(1, N, 1, a, b);
			sb.append(node.min).append(" ").append(node.max).append("\n");
		}

		System.out.println(sb);
	}

	static Node init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = new Node(nums[start], nums[start]);
		}

		int mid = (start + end) / 2;
		Node left = init(start, mid, node * 2);
		Node right = init(mid + 1, end, node * 2 + 1);

		return tree[node] = new Node(Math.min(left.min, right.min), Math.max(left.max, right.max));
	}

	static Node minmax(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return tree[0];
		}
		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		Node leftNode = minmax(start, mid, node * 2, left, right);
		Node rightNode = minmax(mid + 1, end, node * 2 + 1, left, right);

		return new Node(Math.min(leftNode.min, rightNode.min), Math.max(leftNode.max, rightNode.max));
	}

	static class Node {
		int min, max;

		public Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
}
