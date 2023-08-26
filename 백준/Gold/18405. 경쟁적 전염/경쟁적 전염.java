import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, K, S, X, Y;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Queue<Node>> ques = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        graph = new int[N][N];
        IntStream.rangeClosed(0, K).forEach(i -> ques.add(new LinkedList<>()));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        S = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    ques.get(graph[i][j]).add(new Node(i, j, graph[i][j]));
                }
            }
        }

        bfs();

        System.out.println(graph[X - 1][Y - 1]);
    }

    static void bfs() {
        int time = 0;
        boolean isFinish = true;

        while (time++ < S) {
            for (Queue<Node> que : ques) {
                Queue<Node> q = new LinkedList<>(que);

                while (!q.isEmpty()) {
                    Node nowNode = q.poll();
                    int x = nowNode.x;
                    int y = nowNode.y;
                    int n = nowNode.num;

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 0)) {
                            graph[nx][ny] = n;
                            ques.get(n).add(new Node(nx, ny, n));
                            isFinish = false;
                        }
                    }
                }
            }

            if (isFinish || graph[X - 1][Y - 1] != 0) break;
        }
    }

    static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
