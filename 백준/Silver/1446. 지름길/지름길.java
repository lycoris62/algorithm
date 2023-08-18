import java.util.*;

public class Main {

    static int N, D;
    static int[] dp;
    static final int MAX = 10_001;
    static Map<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        D = sc.nextInt();
        dp = new int[MAX];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();

            if (!map.containsKey(end)) map.put(end, new ArrayList<>());
            map.get(end).add(new Node(start, distance));

        }
        
        sol();
        System.out.println(dp[D]);
    }

    static void sol() {
        for (int i = 1; i < MAX; i++) {
            int temp = dp[i - 1] + 1;

            if (map.containsKey(i)) {
                for (Node node : map.get(i)) {
                    temp = Math.min(temp, dp[node.index] + node.distance);
                }
            }
            
            dp[i] = temp;
        }
    }

    static class Node {
        int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
