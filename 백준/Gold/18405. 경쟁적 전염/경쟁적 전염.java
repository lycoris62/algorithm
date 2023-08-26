import java.util.*;

public class Main {

    static int N, K, S, X, Y;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        S = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        List<Node> temp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    temp.add(new Node(i, j, graph[i][j], 0));
                }
            }
        }

        Collections.sort(temp);
        q.addAll(temp);

        bfs();

        System.out.println(graph[X - 1][Y - 1]);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int x = nowNode.x;
            int y = nowNode.y;
            int n = nowNode.num;
            int time = nowNode.time;

            if (time == S) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 0)) {
                    graph[nx][ny] = n;
                    q.add(new Node(nx, ny, n, time + 1));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, num, time;

        public Node(int x, int y, int num, int time) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num, o.num);
        }
    }
}
