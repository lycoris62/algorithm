import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E, K;
    static int[] distances;
    static int INF = Integer.MAX_VALUE / 2;
    static StringBuilder sb = new StringBuilder();
    static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        K = stoi(br.readLine());

        distances = new int[V + 1];
        Arrays.fill(distances, INF);

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(stoi(st.nextToken()))
                .add(new Edge(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            sb.append(distances[i] == INF ? "INF" : distances[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Edge nowNode = pq.poll();
            int now = nowNode.index;
            int nowCost = nowNode.cost;

            if (distances[now] < nowCost) {
                continue;
            }

            for (Edge edge : graph.get(now)) {
                int cost = distances[now] + edge.cost;
                if (cost < distances[edge.index]) {
                    distances[edge.index] = cost;
                    pq.add(new Edge(edge.index, cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int index, cost;

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

