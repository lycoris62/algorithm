import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] graph;
    static Queue<Integer[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;
    static int M;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new Integer[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) graph[i][j] = Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    q.add(new Integer[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        boolean isZero = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    isZero = true;
                    break;
                } else res = Math.max(res, graph[i][j]);
            }
            if (isZero) break;
        }

        System.out.println(isZero ? -1 : res - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer[] xy = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new Integer[]{nx, ny});
                    graph[nx][ny] = graph[xy[0]][xy[1]] + 1;
                }
            }
        }
    }
}
