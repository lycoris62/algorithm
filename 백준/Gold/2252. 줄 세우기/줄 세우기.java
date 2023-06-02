import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] edgeCount;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        edgeCount = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            graph.get(B).add(A);
            edgeCount[A]++;
        }

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int idx = q.poll();
            stack.push(idx);
            List<Integer> list = graph.get(idx);
            for (int x : list) {
                edgeCount[x]--;
                if (edgeCount[x] == 0) {
                    q.add(x);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
