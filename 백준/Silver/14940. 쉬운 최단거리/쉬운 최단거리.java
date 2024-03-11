import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] graph, ans;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        graph = new int[N][M];
        ans = new int[N][M];
        visited = new boolean[N][M];

        int ox = 0;
        int oy = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = stoi(st.nextToken());
                if (x == 2) {
                    ox = i;
                    oy = j;
                }
                graph[i][j] = x;

                ans[i][j] = x == 0 ? 0 : -1;
            }
        }

        bfs(ox, oy);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int ox, int oy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(ox, oy, 0));
        visited[ox][oy] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            ans[now.x][now.y] = now.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] != 0)) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }
    }
}

class Node {

    int x, y, cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
