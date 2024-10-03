import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, V;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        bfs();

        System.out.println(sb);
    }

    static void bfs() {
        visited = new boolean[N + 1];
        visited[V] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        sb.append(V).append(" ");

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    sb.append(next).append(" ");
                }
            }
        }

        sb.append("\n");
    }

    static void dfs(int now) {
        sb.append(now).append(" ");
        visited[now] = true;

        for (Integer next : graph.get(now)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
