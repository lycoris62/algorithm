import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E, K;
    static int INF = Integer.MAX_VALUE / 10;
    static boolean[] visited;
    static int[] distances;
    static List<List<Edge>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        K = stoi(br.readLine());

        distances = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            distances[i] = INF;
        }

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            sb.append(distances[i] == INF ? "INF" : distances[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        distances[start] = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.v]) {
                continue;
            }

            visited[now.v] = true;

            for (Edge next : graph.get(now.v)) {
                if (distances[next.v] > now.w + next.w) {
                    distances[next.v] = now.w + next.w;
                    pq.add(new Edge(next.v, now.w + next.w));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
