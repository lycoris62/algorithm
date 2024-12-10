import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = Integer.MAX_VALUE / 10;
    static int N, M, S, D;
    static int[] distances;
    static List<List<Edge>> graph;
    static List<List<Integer>> prevGraph;
    static boolean[][] visitedFirst;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            S = stoi(st.nextToken());
            D = stoi(st.nextToken());

            distances = new int[N];
            graph = new ArrayList<>();
            prevGraph = new ArrayList<>();
            visitedFirst = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
                prevGraph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());
                int p = stoi(st.nextToken());
                graph.get(u).add(new Edge(v, p));
            }

            dijkstra();
            checkFirstVisit(S, D);
            dijkstra();
            sb.append(distances[D] == MAX ? -1 : distances[D]).append("\n");
        }

        System.out.println(sb);
    }

    static void checkFirstVisit(int start, int dest) {
        if (start == dest) {
            return;
        }

        for (Integer next : prevGraph.get(dest)) {
            if (!visitedFirst[next][dest]) {
                visitedFirst[next][dest] = true;
                checkFirstVisit(start, next);
            }
        }
    }

    static void dijkstra() {
        Queue<Edge> q = new PriorityQueue<>();
        Arrays.fill(distances, MAX);
        distances[S] = 0;
        q.add(new Edge(S, 0));

        while (!q.isEmpty()) {
            Edge now = q.poll();

            if (now.p > distances[now.v]) {
                continue;
            }

            for (Edge next : graph.get(now.v)) {
                if (visitedFirst[now.v][next.v]) {
                    continue;
                }

                if (distances[next.v] > distances[now.v] + next.p) {
                    distances[next.v] = distances[now.v] + next.p;
                    prevGraph.get(next.v).clear();
                    prevGraph.get(next.v).add(now.v);
                    q.add(new Edge(next.v, distances[next.v]));
                } else if (distances[next.v] == distances[now.v] + next.p) {
                    prevGraph.get(next.v).add(now.v);
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int v, p;

        public Edge(int v, int p) {
            this.v = v;
            this.p = p;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.p, o.p);
        }
    }
}
