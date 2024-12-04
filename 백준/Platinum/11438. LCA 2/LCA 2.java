import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxHeight;
    static int[] depth;
    static int[][] parents;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        maxHeight = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        depth = new int[N + 1];
        parents = new int[N + 1][maxHeight];

        init(1, 1, 0);

        for (int i = 1; i < maxHeight; i++) {
            for (int j = 1; j <= N; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }

        M = stoi(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            sb.append(lca(x, y)).append("\n");
        }

        System.out.println(sb);
    }

    static void init(int now, int height, int parent) {
        depth[now] = height;
        for (Integer next : graph.get(now)) {
            if (next != parent) {
                init(next, height + 1, now);
                parents[next][0] = now;
            }
        }
    }

    static int lca(int x, int y) {
        int xDepth = depth[x];
        int yDepth = depth[y];

        if (xDepth < yDepth) {
            int temp = x;
            x = y;
            y = temp;
        }

        // 두 노드의 높이를 맞춰줌
        for (int i = maxHeight - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[x] - depth[y]) {
                x = parents[x][i];
            }
        }

        // 둘의 부모가 같다면 리턴
        if (x == y) {
            return x;
        }

        // 같지 않다면 조상 찾기
        for (int i = maxHeight - 1; i >= 0; i--) {
            if (parents[x][i] != parents[y][i]) {
                x = parents[x][i];
                y = parents[y][i];
            }
        }

        return parents[x][0];
    }
}
