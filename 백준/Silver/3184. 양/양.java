import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R, C, sheep = 0, wolves = 0;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && graph[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.printf("%d %d\n", sheep, wolves);
    }

    static void bfs(int ox, int oy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ox, oy});
        visited[ox][oy] = true;
        int tempSheep = 0;
        int tempWolves = 0;

        if (graph[ox][oy] == 'v') {
            tempWolves++;
        } else if (graph[ox][oy] == 'o') {
            tempSheep++;
        }

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny]) && (graph[nx][ny] != '#')) {
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == 'v') {
                        tempWolves++;
                    } else if (graph[nx][ny] == 'o') {
                        tempSheep++;
                    }
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (tempSheep > tempWolves) {
            sheep += tempSheep;
        } else {
            wolves += tempWolves;
        }
    }
}
