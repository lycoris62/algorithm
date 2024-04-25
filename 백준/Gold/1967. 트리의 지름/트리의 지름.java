import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, maxNode, answer;
    static List<List<Edge>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        answer = Integer.MIN_VALUE;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        // 루트 노드(1번) 에서 가는데 가장 비용이 큰 노드 구하기. (maxNode)
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        // maxNode 에서 다른 노드로 가는데 가장 큰 비용이 드는 경로 구하기 
        visited = new boolean[N + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);

        System.out.println(answer);
    }

    static void dfs(int now, int totalCost) {
        if (answer < totalCost) {
            answer = totalCost;
            maxNode = now;
        }

        for (Edge edge : graph.get(now)) {
            if (!visited[edge.dest]) {
                visited[edge.dest] = true;
                dfs(edge.dest, totalCost + edge.cost);
            }
        }
    }

    static class Edge {

        int dest, cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
