import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M;
    static int[] distances;
    static int INF = Integer.MAX_VALUE / 2;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        distances = new int[N + 1];

        Arrays.fill(distances, INF);
        IntStream.rangeClosed(0, N).forEach(i -> graph.add(new ArrayList<>()));

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        dijkstra();
        System.out.println(distances[N]);
    }

    static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        distances[1] = 0;

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

        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
