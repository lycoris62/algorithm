import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
	static int[] tree, nums;
	static final int INF = Integer.MAX_VALUE / 2;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
		nums = new int[N + 1];
		tree = new int[4 * N];
		nums[0] = tree[0] = INF;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = stoi(st.nextToken());
		}

		init(1, N, 1);

		M = stoi(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = stoi(st.nextToken());

			if (order == 1) {
				int I = stoi(st.nextToken());
				int V = stoi(st.nextToken());
				nums[I] = V;
				update(1, N, 1, I);
			} else {
				sb.append(tree[1]).append("\n");
			}
		}

		System.out.println(sb);
    }

	static int getIndex(int left, int right) {
		if (nums[left] == nums[right]) {
			return Math.min(left, right);
		}

		return nums[left] < nums[right] ? left : right;
	}

	static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = start;
		}

		int mid = (start + end) / 2;
		int left = init(start, mid, node * 2);
		int right = init(mid + 1, end, node * 2 + 1);

		return tree[node] = getIndex(left, right);
	}

	static int update(int start, int end, int node, int index) {
		if (index < start || end < index) {
			return tree[node];
		}

		if (start == end) {
			return tree[node] = index;
		}

		int mid = (start + end) / 2;
		int left = update(start, mid, node * 2, index);
		int right = update(mid + 1, end, node * 2 + 1, index);

		return tree[node] = getIndex(left, right);
	}
}
