import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int T, N, K, W;
    static int[] times, inDegree, totalTimes;
    static List<List<Integer>> graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            K = sc.nextInt();

            times = new int[N + 1];
            inDegree = new int[N + 1];

            IntStream.rangeClosed(1, N).forEach(i -> times[i] = sc.nextInt());
            totalTimes = Arrays.copyOf(times, times.length);

            graph = new ArrayList<>();
            IntStream.rangeClosed(0, N).forEach(i -> graph.add(new ArrayList<>()));

            for (int i = 1; i <= K; i++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                inDegree[Y]++;
                graph.get(X).add(Y);
            }

            W = sc.nextInt();

            topology();
        }
    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int start = q.poll();

            for (int end : graph.get(start)) {
                totalTimes[end] = Math.max(totalTimes[end], totalTimes[start] + times[end]);
                inDegree[end]--;
                if (inDegree[end] == 0)
                    q.add(end);
            }
        }

        System.out.println(totalTimes[W]);
    }
}
