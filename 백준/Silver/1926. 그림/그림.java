import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int maxArea = 0;
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(stt.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    count++;
                    maxArea = Math.max(bfs(i, j, graph), maxArea);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    static int bfs(int ox, int oy, int[][] graph) {
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ox, oy});
        visited[ox][oy] = true;
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = coord[0] + dx[i];
                int ny = coord[1] + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && graph[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = 0;
                    q.add(new int[]{nx, ny});
                    area++;
                }
            }
        }

        return area;
    }
}
