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
        Node hedgehog = null;

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                char x = row.charAt(j);
                graph[i][j] = x;

                if (x == 'S') {
                    start = new Node(i, j, 0, 'S');
                } else if (x == '*') {
                    q.add(new Node(i, j, 0, '*'));
                } else if (x == 'D') {
                    end = new Node(i, j, 0, 'D');
                }
            }
        }

        q.add(start);
        visited[start.x][start.y] = true;

        int ans = bfs();
        System.out.println(ans == -1 ? "KAKTUS" : ans);
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == end.x && now.y == end.y) {
                return now.cnt;
            }

            if (now.who == '*') {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny])) {
                        if (graph[nx][ny] == 'S' || graph[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            graph[nx][ny] = now.who;
                            q.add(new Node(nx, ny, 0, '*'));
                        }
                    }
                }
            } else if (now.who == 'S') {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if ((0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny])) {
                        if (graph[nx][ny] == '.' || graph[nx][ny] == 'D') {
                            visited[nx][ny] = true;
                            graph[nx][ny] = now.who;
                            q.add(new Node(nx, ny, now.cnt + 1, 'S'));
                        }
                    }
                }
            }

//            for (int i = 0; i < 4; i++) {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//
//                if ((0 <= nx && nx < R) && (0 <= ny && ny < C)) {
//                    if (now.who == '*') {
//                        if (graph[nx][ny] == 'S' || graph[nx][ny] == '.') {
////                            graph[nx][ny] = '*';
//                            q.add(new Node(nx, ny, 0, '*'));
//                        }
//                    } else if (now.who == 'S') {
//                        if (graph[nx][ny] == '.' || graph[nx][ny] == 'D') {
//                            q.add(new Node(nx, ny, now.cnt + 1, 'S'));
//                        }
//
//                        for (char[] row : graph) {
//                            System.out.println(row);
//                        }
//                        System.out.println();
//                    }
//                }
//            }
        }

        return -1;
    }

    static class Node {

        int x, y, cnt;
        char who;

        public Node(int x, int y, int cnt, char who) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.who = who;
        }
    }
}
