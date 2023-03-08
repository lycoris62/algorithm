package p1240;

import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static int[][] graph;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = stoi(st.nextToken()) - 1;
            int b = stoi(st.nextToken()) - 1;
            int cost = stoi(st.nextToken());
            graph[a][b] = cost;
            graph[b][a] = cost;
        }

        for (int i = 0; i < M; i++) {
            res = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            int start = stoi(st.nextToken()) - 1;
            int end = stoi(st.nextToken()) - 1;
            boolean[] visited = new boolean[N];
            visited[start] = true;
            dfs(start, end, 0, visited);
            System.out.println(res);
        }
    }

    static void dfs(int now, int end, int total, boolean[] visited) {
        if (now == end) {
            if (total != 0)
                res = Math.min(res, total);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == false && graph[now][i] != 0) {
                visited[i] = true;
                dfs(i, end, total + graph[now][i], visited);
                visited[i] = false;
            }
        }
    }
}

/*
4 2
2 1 2
4 3 2
1 4 3
1 2
3 2

 */