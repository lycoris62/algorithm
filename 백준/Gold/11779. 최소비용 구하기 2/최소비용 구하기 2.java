import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, start, end;
    static int[] distances, prevPath;
    static List<List<Edge>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(br.readLine());

        distances = new int[N + 1];
        prevPath = new int[N + 1];

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

        dijkstra();

        sb.append(distances[end]).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(end);

        while (prevPath[end] != 0) {
            stack.push(prevPath[end]);
            end = prevPath[end];
        }

        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        boolean[] visited = new boolean[N + 1];
        Queue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(distances, Integer.MAX_VALUE);
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
                    prevPath[next.dest] = now.dest;
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
