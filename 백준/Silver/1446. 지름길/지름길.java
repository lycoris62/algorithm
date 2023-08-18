import java.util.*;

public class Main {

    static int N, D;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    static final int MAX = 10_001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        dist = new int[MAX];
        Arrays.fill(dist, MAX);

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < MAX - 1; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(start).add(new Node(end, cost));
        }

        dijkstra();

        System.out.println(dist[D]);
    }

    static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.index;
            int distance = nowNode.cost;

            if (dist[now] < distance) continue;

            for (Node node : graph.get(now)) {
                int cost = distance + node.cost;

                if (cost < dist[node.index]) {
                    dist[node.index] = cost;
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
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
