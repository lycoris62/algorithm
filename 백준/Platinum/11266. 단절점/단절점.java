import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E, seq = 1, count;
    static int[] sequences;
    static boolean[] isCutVertex;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        sequences = new int[V + 1];
        isCutVertex = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= V; i++) {
            if (sequences[i] == 0) {
                dfs(i, true);
            }
        }

        for (int i = 1; i <= V; i++) {
            if (isCutVertex[i]) {
                count++;
            }
        }

        sb.append(count).append("\n");

        for (int i = 1; i <= V; i++) {
            if (isCutVertex[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static int dfs(int vertex, boolean isRoot) {
        int result = sequences[vertex] = seq++;
        int childCount = 0;

        for (Integer child : graph.get(vertex)) {
            if (sequences[child] != 0) {
                result = Math.min(result, sequences[child]);
                continue;
            }

            childCount++;
            int low = dfs(child, false);

            if (!isRoot && low >= sequences[vertex]) {
                isCutVertex[vertex] = true;
            }

            result = Math.min(result, low);
        }

        if (isRoot && childCount >= 2) {
            isCutVertex[vertex] = true;
        }

        return result;
    }
}
