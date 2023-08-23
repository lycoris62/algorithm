import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, X, res;
    static int[] distances;
    static int MAX = Integer.MAX_VALUE / 2;
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        distances = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(start).add(new Node(end, cost));
            reverseGraph.get(end).add(new Node(start, cost));
        }

        int[] list1 = dijkstra(graph);
        int[] list2 = dijkstra(reverseGraph);

        IntStream.rangeClosed(1, N).forEach(i -> res = Math.max(res, list1[i] + list2[i]));

        System.out.println(res);
    }

    static int[] dijkstra(List<List<Node>> graph) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        IntStream.rangeClosed(1, N).forEach(i -> distances[i] = MAX);
        distances[X] = 0;

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

        return Arrays.copyOf(distances, distances.length);
    }

    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
