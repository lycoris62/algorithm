import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, K, X;
    static int[] distances;
    static int INF = Integer.MAX_VALUE / 2;
    static StringBuilder sb = new StringBuilder();
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        
        distances = new int[N + 1];
        Arrays.fill(distances, INF);

        IntStream.rangeClosed(0, N).forEach(i -> graph.add(new ArrayList<>()));
        IntStream.range(0, M).forEach(i -> graph.get(sc.nextInt()).add(new Node(sc.nextInt(), 1)));

        dijkstra(X);
        IntStream.rangeClosed(1, N).filter(i -> distances[i] == K).forEach(i -> sb.append(i).append("\n"));

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.index;
            int nowCost = nowNode.cost;

            if (distances[now] < nowCost) continue;

            for (Node node : graph.get(now)) {
                int cost = distances[now] + node.cost;
                if (cost < distances[node.index]) {
                    distances[node.index] = cost;
                    pq.add(new Node(node.index, cost));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
