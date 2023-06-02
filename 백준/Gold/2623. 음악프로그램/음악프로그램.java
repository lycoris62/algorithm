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

    static boolean[] visited;
    static boolean[] finished;
    static boolean isCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        edgeCount = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stoi(st.nextToken());
            int in = stoi(st.nextToken());
            while (st.hasMoreTokens()) {
                int out = stoi(st.nextToken());
                if (in == out) continue;
                graph.get(out).add(in);
                edgeCount[in]++;
                in = out;
            }
        }

        for (int i = 1; i < edgeCount.length; i++) {
            isCycle = false;
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            checkCycle(i);
            if (isCycle) {
                System.out.println("0");
                return;
            }
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
            sb.append(stack.pop()).append("\n");
        }

        System.out.println(sb);
    }

    static void checkCycle(int v) {
        visited[v] = true;
        for (int u : graph.get(v)) {
            if (!visited[u]) {
                checkCycle(u);
            } else if (!finished[u]) {
                isCycle = true;
            }
        }
        finished[v] = true;
    }
}
