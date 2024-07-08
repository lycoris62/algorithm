import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        graph = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1] = stoi(st.nextToken());
        }

        for (int mid = 0; mid < V; mid++) {
            for (int start = 0; start < V; start++) {
                for (int end = 0; end < V; end++) {
                    if (graph[start][end] > graph[start][mid] + graph[mid][end]) {
                        graph[start][end] = graph[start][mid] + graph[mid][end];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    continue;
                }

                int length = graph[i][j] + graph[j][i];

                answer = Math.min(answer, length);
            }
        }

        System.out.println(answer >= Integer.MAX_VALUE / 2 ? -1 : answer);
    }
}
