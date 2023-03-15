import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, V;
    static int[][] graph;
    static StringBuilder sbBFS = new StringBuilder(), sbDFS = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = stoi(st.nextToken()) - 1;
            int b = stoi(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V - 1, 0, new boolean[N]);
        bfs();

        System.out.println(sbDFS);
        System.out.println(sbBFS);
    }

    static void dfs(int now, int depth, boolean[] visited) {
        if (depth == N) return;

        visited[now] = true;
        sbDFS.append((now + 1) + " ");

        for (int i = 0; i < N; i++) {
            if (!visited[i] && graph[now][i] != 0) {
                visited[i] = true;
                dfs(i, depth + 1, visited);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V - 1);
        boolean[] visited = new boolean[N];
        visited[V - 1] = true;
        sbBFS.append((V) + " ");

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < N; i++) {
                if (!visited[i] && graph[now][i] != 0) {
                    q.add(i);
                    visited[i] = true;
                    sbBFS.append((i + 1) + " ");
                }
            }
        }
    }
}
