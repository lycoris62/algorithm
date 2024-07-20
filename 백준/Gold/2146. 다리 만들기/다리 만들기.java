import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;
    static int number = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0 && !visited[i][j]) {
                    setNumber(i, j);
                    number++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    visited = new boolean[N][N];
                    int count = bfs(i, j);

                    answer = Math.min(answer, count);
                }
            }
        }

        System.out.println(answer);
    }

    static void setNumber(int ox, int oy) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(ox, oy));
        visited[ox][oy] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            graph[now.x][now.y] = number;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] != 0)) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }

    static int bfs(int ox, int oy) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(ox, oy, 0));
        visited[ox][oy] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (graph[now.x][now.y] != 0 && graph[now.x][now.y] != graph[ox][oy]) {
                return now.cnt - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] == 0 || graph[nx][ny] != graph[ox][oy])) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
