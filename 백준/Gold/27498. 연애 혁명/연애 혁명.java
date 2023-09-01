import java.io.*;
import java.util.*;

public class Main {

    static int N, M, res;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);

            if (d == 1) {
                union(a, b);
                continue;
            }
            res += c;
        }

        Arrays.sort(edges);

        kruskal();
        System.out.println(res);
    }

    static void kruskal() {
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                res -= edge.cost;
                union(edge.start, edge.end);
            }
        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot) {
            parents[bRoot] = aRoot;
        } else {
            parents[aRoot] = bRoot;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.cost, this.cost);
        }
    }
}
