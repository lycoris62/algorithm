import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L') {
                    int length = bfs(i, j);
                    answer = Math.max(answer, length);
                }
            }
        }

        System.out.println(answer);
    }

    static int bfs(int ox, int oy) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(ox, oy, 0));
        visited = new boolean[N][M];
        visited[ox][oy] = true;
        int length = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            length = Math.max(length, now.cnt);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny]) && (board[nx][ny] == 'L')) {
                    q.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return length;
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
