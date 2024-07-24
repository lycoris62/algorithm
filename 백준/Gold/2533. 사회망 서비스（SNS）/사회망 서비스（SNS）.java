import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] dp;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        int answer = Math.min(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }

    static void dfs(int now) {
        visited[now] = true;
        dp[now][0] = 0;
        dp[now][1] = 1;

        for (Integer next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
                dp[now][0] += dp[next][1];
                dp[now][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
