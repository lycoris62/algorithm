import java.io.*;
import java.util.*;

public class Main {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static int N, M, res = 0;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int r = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		int d = stoi(st.nextToken());

		graph = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = stoi(st.nextToken());
			}
		}
		dfs(r, c, d);
	}

	static void dfs(int ox, int oy, int d) {

		if (!visited[ox][oy]) {
			res++;
		}
		visited[ox][oy] = true;

		boolean isRotate = false;
		for (int i = 0; i < 4; i++) {
			int nx = ox + dx[i];
			int ny = oy + dy[i];

			if ((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
				if (graph[nx][ny] == 0 && !visited[nx][ny]) {
					isRotate = true;
				}
			}
		}

		if (isRotate) {
			for (int i = 0; i < 4; i++) {
				d = (d - 1 + 4) % 4;

				int nx = ox + dx[d];
				int ny = oy + dy[d];

				if ((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
					if (graph[nx][ny] == 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						res++;
						dfs(nx, ny, d);
					}
				}
			}
		} else {
			int bx = ox + dx[(d + 2) % 4];
			int by = oy + dy[(d + 2) % 4];

			if (graph[bx][by] == 1) {
				System.out.println(res);
				System.exit(0);
			}

			if (!visited[bx][by]) {
				res++;
			}
			visited[bx][by] = true;
			dfs(bx, by, d);
		}
	}
}
