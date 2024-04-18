import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.pollFirst();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[nx][ny] != '0') && (!visited[nx][ny])) {
                    q.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    static class Node {

        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
