import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int K;
    static Queue<Integer> q;
    static int MAX_NUM = 100_001;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        q = new LinkedList<>();
//        MAX_NUM = Math.max(N, K) + 1;
        visited = new int[MAX_NUM];

        bfs(N);
        System.out.println(visited[K] - 1);
    }

    static void bfs(int now) {
        q.add(now);
        visited[now] = 1;

        while (!q.isEmpty()) {
            int next = q.poll();

            if (next == K) return;
            else {
                if (0 <= next - 1 && next - 1 < MAX_NUM && visited[next - 1] == 0) {
                    q.add(next - 1);
                    visited[next - 1] = visited[next] + 1;
                }
                if (0 <= next + 1 && next + 1 < MAX_NUM && visited[next + 1] == 0) {
                    q.add(next + 1);
                    visited[next + 1] = visited[next] + 1;
                }
                if (0 <= next * 2 && next * 2 < MAX_NUM && visited[next * 2] == 0) {
                    q.add(next * 2);
                    visited[next * 2] = visited[next] + 1;
                }
            }
        }
    }
}
