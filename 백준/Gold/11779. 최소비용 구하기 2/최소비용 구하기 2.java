import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, start, end;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] distances;
    static List<List<Integer>> paths = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(br.readLine());

        distances = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = stoi(st.nextToken());
            int dest = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            graph.get(src).add(new Edge(dest, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = stoi(st.nextToken());
        end = stoi(st.nextToken());

        dijkstra(start, end);

        sb.append(distances[end]).append("\n").append(paths.get(end).size()).append("\n");
        for (Integer path : paths.get(end)) {
            sb.append(path).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i <= N; i++) {
            paths.add(new ArrayList<>());
        }

        Arrays.fill(distances, Integer.MAX_VALUE);
        paths.get(start).add(start);
        pq.add(new Edge(start, 0));
        distances[start] = 0;

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
                    paths.set(next.dest, new ArrayList<>(paths.get(now.dest)));
                    paths.get(next.dest).add(next.dest);
                    pq.add(new Edge(next.dest, cost));
                }
            }
        }
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
