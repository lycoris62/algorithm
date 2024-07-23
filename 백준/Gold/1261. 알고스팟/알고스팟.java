import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            
            for (int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.crash;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny])) {
                    for (int j = 0; j < 2; j++) {
                        if (graph[nx][ny] == j) {
                            visited[nx][ny] = true;
                            q.add(new Node(nx, ny, now.crash + j));
                        }
                    }
                }
            }
        }

        return 0;
    }

    static class Node implements Comparable<Node> {
        int x, y, crash;

        public Node(int x, int y, int crash) {
            this.x = x;
            this.y = y;
            this.crash = crash;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.crash, node.crash);
        }
    }
}
