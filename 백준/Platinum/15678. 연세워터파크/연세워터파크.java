import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, D;
    static long answer = Long.MIN_VALUE;
    static Deque<Node> q = new ArrayDeque<>();
    static List<Node> nodes = new ArrayList<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        D = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i, Long.parseLong(st.nextToken())));
        }

        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && q.peekLast().idx + D < i) {
                q.pollLast();
            }

            if (q.isEmpty()) {
                q.offerLast(nodes.get(i));
                continue;
            }

            if (q.peekLast().count <= q.peekLast().count + nodes.get(i).count) {
                q.addLast(new Node(i, q.peekLast().count + nodes.get(i).count));
            } else {
                while (q.size() > 1 && q.peekFirst().count <= q.peekLast().count + nodes.get(i).count) {
                    q.pollFirst();
                }

                q.addFirst(new Node(i, q.peekLast().count + nodes.get(i).count));
            }

            if (q.peekLast().count <= nodes.get(i).count) {
                q.addLast(new Node(i, nodes.get(i).count));
            }

            answer = Math.max(answer, q.peekLast().count);
        }

        System.out.println(answer);
    }

    static class Node {

        int idx;
        long count;

        public Node(int idx, long count) {
            this.idx = idx;
            this.count = count;
        }
    }
}