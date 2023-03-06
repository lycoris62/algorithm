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
    static int[] visited = new int[100001];
    static int minSecond = 987654321;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        q = new LinkedList<>();

        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minSecond);
        System.out.println(count);
    }

    static void bfs() {
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (minSecond < visited[now]) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;

                if (next < 0 || 100_000 < next) continue;

                if (next == K) {
                    minSecond = visited[now];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }

        }
    }
}
