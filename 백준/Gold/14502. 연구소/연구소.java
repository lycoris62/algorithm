import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, res = Integer.MIN_VALUE;
    static int[][] graph;
    static List<Point> virus = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        dfs(0);
        System.out.println(res);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            int[][] copyGraph = new int[N][M];
            IntStream.range(0, N).forEach(i -> System.arraycopy(graph[i], 0, copyGraph[i], 0, M));

            virus.forEach(point -> bfs(point.x, point.y, copyGraph));

            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyGraph[i][j] == 0) temp++;
                }
            }

            res = Math.max(res, temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void bfs(int ox, int oy, int[][] graph) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(ox, oy));

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[nx][ny] == 0)) {
                    graph[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
