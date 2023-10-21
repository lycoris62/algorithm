import java.util.Scanner;

public class Main {

	static int R, C, K, answer;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();

		graph = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			graph[i] = sc.next().toCharArray();
		}

		visited[R - 1][0] = true;
		dfs(1, R - 1, 0);

		System.out.println(answer);
	}

	static void dfs(int depth, int x, int y) {
		if (x == 0 && y == C - 1) {
			if (depth == K) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (graph[nx][ny] != 'T') && (!visited[nx][ny])) {
				visited[nx][ny] = true;
				dfs(depth + 1, nx, ny);
				visited[nx][ny] = false;
			}
		}
	}
}
