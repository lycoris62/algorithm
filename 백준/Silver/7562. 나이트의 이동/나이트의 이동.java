import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, I;
    static int[] now = new int[2], dest = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());

        while (T-- > 0) {
            I = stoi(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            now = new int[]{stoi(st.nextToken()), stoi(st.nextToken())};
            st = new StringTokenizer(br.readLine(), " ");
            dest = new int[]{stoi(st.nextToken()), stoi(st.nextToken())};

            System.out.println(bfs(now[0], now[1]));
        }
    }

    static int[][] dxy = new int[][]{
            {-2, 1}, {-2, -1},
            {-1, 2}, {-1, -2},
            {1, 2}, {1, -2},
            {2, 1}, {2, -1}
    };

    static int bfs(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, m});
        int[][] visited = new int[I][I];
        visited[n][m] = 1;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            if (x == dest[0] && y == dest[1]) {
                return visited[x][y] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dxy[i][0];
                int ny = y + dxy[i][1];

                if (0 <= nx && nx < I && 0 <= ny && ny < I && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return 0;
    }
}