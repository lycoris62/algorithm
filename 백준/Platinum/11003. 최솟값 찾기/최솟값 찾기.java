import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, L;
	static int[] arr;
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		L = stoi(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}

		for (int idx = 0; idx < N; idx++) {

			while (!dq.isEmpty() && arr[dq.peekLast()] > arr[idx]) {
				dq.pollLast();
			}

			dq.offer(idx);

			if (dq.peekFirst() <= idx - L) {
				dq.pollFirst();
			}

			sb.append(arr[dq.peekFirst()]).append(" ");
		}

		System.out.println(sb);
	}

}
