import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = stoi(st.nextToken());
        S = stoi(st.nextToken());
        G = stoi(st.nextToken());
        U = stoi(st.nextToken());
        D = stoi(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[F + 1];
        visited[S] = 1;
        q.add(S);

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == G) {
                System.out.println(visited[x] - 1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int temp = x + (i == 0 ? U : -D);
                if ((1 <= temp && temp <= F) && (visited[temp] == 0)) {
                    q.add(temp);
                    visited[temp] = visited[x] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }
}
