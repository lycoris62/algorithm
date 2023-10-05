import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
	static int[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		graph = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				graph[i][j] = row[j] - '0';
			}
		}

		System.out.println(bfs());
    }

	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				return now.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if ((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
					if (graph[nx][ny] == 1 && now.crash == 0) {
						visited[nx][ny][1] = true;
						q.add(new Node(nx, ny, 1, now.cnt + 1));
					} else if (graph[nx][ny] == 0 && !visited[nx][ny][now.crash]) {
						visited[nx][ny][now.crash] = true;
						q.add(new Node(nx, ny, now.crash, now.cnt + 1));
					}
				}
			}
		}

		return -1;
	}

	static class Node {
		int x, y, crash, cnt;

		public Node(int x, int y, int crash, int cnt) {
			this.x = x;
			this.y = y;
			this.crash = crash;
			this.cnt = cnt;
		}
	}
}
