import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()) - 1;
            int y = stoi(st.nextToken()) - 1;

            graph[x][y] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    int count = bfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);
    }

    static int bfs(int ox, int oy) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(ox, oy));
        visited[ox][oy] = true;
        int count = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (graph[nx][ny] == 1)) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
