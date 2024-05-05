import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R, C;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Node start, end;
    static Queue<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                char x = row.charAt(j);
                graph[i][j] = x;

                if (x == 'S') {
                    start = new Node(i, j, 0);
                } else if (x == '*') {
                    q.add(new Node(i, j, 0));
                } else if (x == 'D') {
                    end = new Node(i, j, 0);
                }
            }
        }

        q.add(start);
        visited[start.x][start.y] = true;

        int ans = bfs();
        System.out.println(ans == -1 ? "KAKTUS" : ans);
    }

    // visited 가 있어야 하는 이유 알아냄
    // - visited 가 없으면 큐에 넣어진 것이 고슴도치(S) 였을지라도,
    // graph[now.x][now.y] 가 홍수가 지나갔다면 물(*)로 로직이 돌아감. 진짜 바보다..

    static int bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            char who = graph[now.x][now.y];

            if (now.x == end.x && now.y == end.y) {
                return now.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!isAccessible(nx, ny)) {
                    continue;
                }

                if (isWaterMovable(who, graph[nx][ny]) || isHedgehogMovable(who, graph[nx][ny])) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = who;
                    q.add(new Node(nx, ny, now.time + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isHedgehogMovable(char who, char next) {
        return who == 'S' && (next == '.' || next == 'D');
    }

    private static boolean isWaterMovable(char who, char next) {
        return who == '*' && (next == 'S' || next == '.');
    }

    private static boolean isAccessible(int nx, int ny) {
        return (0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny]);
    }

    static class Node {

        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
