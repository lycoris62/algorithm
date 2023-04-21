import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int lx = stoi(st.nextToken());
            int ly = stoi(st.nextToken());
            int rx = stoi(st.nextToken());
            int hy = stoi(st.nextToken());

            for (int j = ly; j < hy; j++) {
                for (int k = lx; k < rx; k++) {
                    graph[j][k] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int x : list) {
            System.out.printf("%d ", x);
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int count = 0;

        while (!q.isEmpty()) {
            int[] xyc = q.poll();
            int ox = xyc[0];
            int oy = xyc[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = ox + dx[i];
                int ny = oy + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == 0)) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}
