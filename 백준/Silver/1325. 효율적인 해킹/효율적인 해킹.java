import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] counts;
    static List<List<Integer>> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        counts = new int[N];

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken()) - 1;
            int B = stoi(st.nextToken()) - 1;

            list.get(A).add(B);
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        int maxCount = Arrays.stream(counts).max().getAsInt();

        for (int i = 0; i < N; i++) {
            if (counts[i] == maxCount) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] visited = new boolean[N];
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (Integer next : list.get(now)) {
                if (!visited[next]) {
                    q.add(next);
                    counts[next]++;
                    visited[next] = true;
                }
            }
        }
    }
}
