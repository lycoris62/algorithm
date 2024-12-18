import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] energy, parents, answer;
    static List<List<Edge>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        energy = new int[N + 1];
        parents = new int[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            energy[i] = stoi(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        dfs(1, 0);

        for (int i = N; 0 < i; i--) {
            answer[i] = process(i, energy[i]);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now, int parent) {
        parents[now] = parent;

        for (Edge next : graph.get(now)) {
            if (next.dest != parent) {
                dfs(next.dest, now);
            }
        }
    }

    static int process(int now, int energy) {
        while (now != 1) {
            int parent = parents[now];
            int nextCost = 0;

            for (Edge next : graph.get(now)) {
                if (next.dest == parent) {
                    nextCost = next.cost;
                    break;
                }
            }

            if (energy < nextCost) {
                return now;
            }

            energy -= nextCost;
            now = parent;
        }

        return 1;
    }

    static class Edge {

        int dest, cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
