import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, M, K, X;
    static int[] dist;
    static List<List<Integer>> graph = new ArrayList<>();
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
        IntStream.range(0, M).forEach(i -> graph.get(sc.nextInt()).add(sc.nextInt()));

        dijkstra(X);

        long cnt = Arrays.stream(dist).filter(x -> x == K).count();
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            IntStream.rangeClosed(1, N).filter(i -> dist[i] == K).forEach(System.out::println);
        }
    }

    static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] nowNode = pq.poll();

            int now = nowNode[0];
            int distance = nowNode[1];

            if (dist[now] < distance) continue;

            for (int next : graph.get(now)) {
                int cost = dist[now] + 1;

                if (cost < dist[next]) {
                    dist[next] = cost;
                    pq.add(new int[]{next, cost});
                }
            }
        }
    }
}
