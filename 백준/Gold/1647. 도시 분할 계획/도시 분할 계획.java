import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, res = 0;
    static int[] parents;
    static List<int[]> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edgeList.add(new int[]{stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())});
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        edgeList.sort(Comparator.comparing(e -> e[2]));

        int bigCost = 0;
        for (int[] edge : edgeList) {
            if (find(edge[0]) != find(edge[1])) {
                res += edge[2];
                union(edge[0], edge[1]);
                bigCost = edge[2];
            }
        }

        System.out.println(res - bigCost);
    }

    static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot)
            parents[bRoot] = aRoot;
    }
}
