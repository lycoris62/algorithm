import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, a, b;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = stoi(st.nextToken()) - 1;
        b = stoi(st.nextToken()) - 1;

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 0));
        boolean[] visited = new boolean[N];
        visited[a] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == b) {
                return now.count;
            }

            int jump = arr[now.x];

            for (int next = now.x + jump; next < N; next += jump) {
                if (!visited[next]) {
                    q.add(new Node(next, now.count + 1));
                    visited[next] = true;
                }
            }

            for (int next = now.x - jump; next >= 0; next -= jump) {
                if (!visited[next]) {
                    q.add(new Node(next, now.count + 1));
                    visited[next] = true;
                }
            }
        }

        return -1;
    }

    static class Node {

        int x, count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}
