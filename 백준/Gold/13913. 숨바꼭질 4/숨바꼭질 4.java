import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N, K;
	static boolean[] visited;
	static int[] pres;
	static StringBuilder sb = new StringBuilder();
	static final int MAX = 100_001;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visited = new boolean[MAX];
		pres = new int[MAX];
		Arrays.fill(pres, -1);

		bfs();
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Element> q = new LinkedList<>();
		visited[N] = true;
		q.add(new Element(N, 0, new LinkedList<>(List.of(N))));

		while (!q.isEmpty()) {
			Element now = q.poll();

			if (now.idx == K) {
				sb.append(now.cnt).append("\n");

				int idx = now.idx;
				Stack<Integer> st = new Stack<>();
				while (idx != -1) {
					st.push(idx);
					idx = pres[idx];
				}
				while (!st.isEmpty()) {
					sb.append(st.pop()).append(" ");
				}
				return;
			}

			for (int i = 0; i < 3; i++) {
				int next = getNext(i, now.idx);
				if (0 <= next && next < MAX && !visited[next]) {
					q.add(new Element(next, now.cnt + 1, new LinkedList<>()));
					pres[next] = now.idx;
					visited[next] = true;
				}
			}
		}
	}

	static int getNext(int i, int x) {
		if (i == 0) return x * 2;
		else if (i == 1) return x - 1;
		else return x + 1;
	}

	static class Element {
		int idx, cnt;
		Queue<Integer> q;

		public Element(int idx, int cnt, Queue<Integer> q) {
			this.idx = idx;
			this.cnt = cnt;
			this.q = q;
		}
	}
}
