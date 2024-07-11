import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int M, N, answer;
    static int[] parents;
    static List<Edge> edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());

            if (M == 0 && N == 0) {
                break;
            }

            answer = 0;
            edges = new ArrayList<>();

            parents = new int[M];
            for (int i = 0; i < M; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int X = stoi(st.nextToken());
                int Y = stoi(st.nextToken());
                int Z = stoi(st.nextToken());

                answer += Z;

                edges.add(new Edge(X, Y, Z));
                edges.add(new Edge(Y, X, Z));
            }

            Collections.sort(edges);

            for (Edge edge : edges) {
                if (union(edge.x, edge.y)) {
                    answer -= edge.z;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        int lowRoot = Math.min(aRoot, bRoot);
        int highRoot = Math.max(aRoot, bRoot);

        parents[lowRoot] = highRoot;
        return true;
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static class Edge implements Comparable<Edge> {
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.z, o.z);
        }
    }
}
