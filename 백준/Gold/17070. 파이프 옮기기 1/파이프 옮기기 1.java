import java.util.Scanner;

public class Main {

	static int N, res;
	static int[][] graph;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		dfs(0, 1, 0);
		System.out.println(res);
	}

	static void dfs(int ox, int oy, int dir) {
		if (ox == N - 1 && oy == N - 1) {
			res++;
			return;
		}

		if (isHorizontalAvailable(ox, oy) && (dir == 0 || dir == 2)) {
			dfs(ox + dx[0], oy + dy[0], 0);
		}

		if (isVerticalAvailable(ox, oy) && (dir == 1 || dir == 2)) {
			dfs(ox + dx[1], oy + dy[1], 1);
		}

		if (isDiagonalAvailable(ox, oy)) {
			dfs(ox + dx[2], oy + dy[2], 2);
		}
	}

	static boolean isHorizontalAvailable(int x, int y) {
		int nx = x + dx[0];
		int ny = y + dy[0];

		return (0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 0);
	}

	static boolean isVerticalAvailable(int x, int y) {
		int nx = x + dx[1];
		int ny = y + dy[1];

		return (0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 0);
	}

	static boolean isDiagonalAvailable(int x, int y) {
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (!((0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 0))) {
				return false;
			}
		}

		return true;
	}
}
