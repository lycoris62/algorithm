import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K, L, D = 1, time = 0;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Map<Integer, String> dirChange = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1] = 1;
        }

        L = stoi(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dirChange.put(stoi(st.nextToken()), st.nextToken());
        }

        dfs(0, 0, new LinkedList<>(List.of(new Point(0, 0))));
        System.out.println(time);
    }
    
    static void dfs(int x, int y, Queue<Point> snake) {
        time++;
        int nx = x + dx[D];
        int ny = y + dy[D];

        if (nx < 0 || N <= nx || ny < 0 || N <= ny) {
            return;
        }

        for (Point point : snake) {
            if (point.x == nx && point.y == ny) {
                return;
            }
        }

        if (graph[nx][ny] == 1) {
            graph[nx][ny] = 0;
        } else {
            snake.poll();
        }

        snake.add(new Point(nx, ny));

        if (dirChange.containsKey(time)) {
            if (dirChange.get(time).equals("L")) {
                D = (D - 1 + 4) % 4;
            } else {
                D = (D + 1) % 4;
            }
        }

        dfs(nx, ny, snake);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

