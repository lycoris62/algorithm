import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M;
	static int[] inDegrees;
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		inDegrees = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());

			graph.get(a).add(b);
			inDegrees[b]++;
		}

		topology();
		System.out.println(sb);
	}

	static void topology() {
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (inDegrees[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			Integer now = q.poll();
			sb.append(now).append(" ");

			for (Integer next : graph.get(now)) {
				inDegrees[next]--;
				if (inDegrees[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
