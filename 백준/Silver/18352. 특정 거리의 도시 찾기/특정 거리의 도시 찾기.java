import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, K, X;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        IntStream.rangeClosed(0, N).forEach(i -> graph.add(new ArrayList<>()));
        IntStream.range(0, M).forEach(i -> graph.get(sc.nextInt()).add(new Node(sc.nextInt(), 1)));

        dijkstra(X);

        long cnt = Arrays.stream(dist).filter(x -> x == K).count();
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            IntStream.rangeClosed(1, N).filter(i -> dist[i] == K).forEach(System.out::println);
        }
    }

    static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();

            int now = nowNode.getIndex();
            int distance = nowNode.getDistance();

            if (dist[now] < distance) continue;

            for (Node node : graph.get(now)) {
                int cost = dist[now] + node.getDistance();

                if (cost < dist[node.getIndex()]) {
                    dist[node.getIndex()] = cost;
                    pq.add(new Node(node.getIndex(), cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.getDistance());
        }
    }
}
