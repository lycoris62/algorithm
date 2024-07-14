import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int K, V, E;
    static boolean flag;
    static int[] colors;
    static List<List<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = stoi(st.nextToken());
            E = stoi(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[V + 1];
            flag = false;

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (flag) {
                    break;
                }

                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }

            sb.append(flag ? "NO" : "YES").append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int nowColor) {
        colors[now] = nowColor;

        for (Integer next : graph.get(now)) {
            if (colors[next] == nowColor) {
                flag = true;
                return;
            }

            if (colors[next] == 0) {
                dfs(next, -1 * nowColor);
            }
        }
    }
}
