import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, minScore = Integer.MAX_VALUE;
    static int[] scores;
    static int[][] graph;
    static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        graph = new int[N][N];
        scores = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken()) - 1;
            int B = stoi(st.nextToken()) - 1;

            if (A == -2) {
                break;
            }

            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        for (int mid = 0; mid < N; mid++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int score = 0;

            for (int j = 0; j < N; j++) {
                if (graph[i][j] != INF) {
                    score = Math.max(score, graph[i][j]);
                }
            }

            minScore = Math.min(minScore, score);
            scores[i] = score;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (scores[i] == minScore) {
                list.add(i + 1);
            }
        }

        System.out.println(minScore + " " + list.size());
        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }
}
