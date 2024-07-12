import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, E, V1, V2;
    static int INF = 200_000 * 1_000 + 1;
    static int[] distances;
    static boolean[] visited;
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        E = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        V1 = stoi(st.nextToken());
        V2 = stoi(st.nextToken());

        int cost1 = dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, N);
        int cost2 = dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, N);

        int cost = Math.min(cost1, cost2);

        System.out.println(cost >= INF ? -1 : cost);
    }

    static int dijkstra(int start, int end) {
        distances = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.dest]) {
                continue;
            }

            visited[now.dest] = true;

            for (Edge next : graph.get(now.dest)) {
                int cost = now.cost + next.cost;

                if (distances[next.dest] > cost) {
                    distances[next.dest] = cost;
                    pq.add(new Edge(next.dest, cost));
                }
            }
        }

        return distances[end];
    }

    static class Edge implements Comparable<Edge> {
        int dest, cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
