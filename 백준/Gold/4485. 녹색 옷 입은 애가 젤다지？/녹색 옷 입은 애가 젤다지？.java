import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, sequence = 1;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while ((N = stoi(br.readLine())) != 0) {
            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = stoi(st.nextToken());
                }
            }

            sb.append("Problem ").append(sequence++).append(": ").append(dijkstra()).append("\n");
        }

        System.out.println(sb);
    }

    static int dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        int[][] distances = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        distances[0][0] = graph[0][0];
        pq.add(new Edge(0, 0, distances[0][0]));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
                    int nextCost = now.cost + graph[nx][ny];
                    if (distances[nx][ny] > nextCost) {
                        distances[nx][ny] = nextCost;
                        pq.add(new Edge(nx, ny, nextCost));
                    }
                }
            }
        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {

        int x, y, cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}