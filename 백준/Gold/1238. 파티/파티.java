import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, X, res;
    static int[] distances, xDist;
    static int MAX = Integer.MAX_VALUE / 2;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        distances = new int[N + 1];

        IntStream.rangeClosed(0, N).forEach(i -> graph.add(new ArrayList<>()));
        IntStream.range(0, M).forEach(i -> graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt())));

        dijkstra(X);
        xDist = Arrays.copyOf(distances, distances.length);

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            dijkstra(i);
            int cost = distances[X] + xDist[i];
            res = Math.max(res, cost);
        }

        System.out.println(res);
    }

    static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        IntStream.rangeClosed(1, N).forEach(i -> distances[i] = MAX);
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

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
