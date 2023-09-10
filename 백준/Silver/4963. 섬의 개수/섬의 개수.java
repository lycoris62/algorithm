import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M, res;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			M = stoi(st.nextToken());
			N = stoi(st.nextToken());
			if (N == 0 && M == 0)
				break;

			graph = new int[N][M];
			visited = new boolean[N][M];
			res = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					graph[i][j] = stoi(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && graph[i][j] == 1) {
						bfs(i, j);
						res++;
					}
				}
			}

			sb.append(res).append("\n");
		}

		System.out.println(sb);
	}

	static void bfs(int ox, int oy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(ox, oy));
		visited[ox][oy] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == 1)) {
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
