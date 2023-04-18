import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] graph;
    static List<Integer> ans;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        graph = new int[N][N];
        ans = new ArrayList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans.size());
        ans.stream().sorted().forEach(System.out::println);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int ox = xy[0];
            int oy = xy[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = ox + dx[i];
                int ny = oy + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (graph[nx][ny] == 1)) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        ans.add(cnt);
    }
}
