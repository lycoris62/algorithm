import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, r1, c1, r2, c2;
    static int[][] visited;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        r1 = stoi(st.nextToken());
        c1 = stoi(st.nextToken());
        r2 = stoi(st.nextToken());
        c2 = stoi(st.nextToken());

        visited = new int[N][N];

        System.out.println(bfs(r1, c1));
    }

    static int bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visited[r][c] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == r2 && now.y == c2) {
                return visited[now.x][now.y] - 1;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (visited[nx][ny] == 0)) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }

        return -1;
    }

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
