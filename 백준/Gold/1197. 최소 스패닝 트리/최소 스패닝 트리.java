import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V;
    static int E;
    static int[] parents;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        edgeList = new Edge[E];
        parents = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edgeList[i] = new Edge(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        
        System.out.println(kruskal());
    }

    static int kruskal() {
        int res = 0, cnt = 0;
        Arrays.sort(edgeList);

        make();

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                res += edge.weight;
                cnt++;
                if (cnt == V - 1) return res;
            }
        }

        return res;
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }

    static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static void make() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
}
