package p2606;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = stoi(st.nextToken()) - 1;
            int b = stoi(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[N];
        visited[0] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }

        return cnt;
    }
}

