import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, L, R, count, unionNum = 0;
    static Cell[][] graph;
    static boolean[][] visited;
    static boolean isOpen;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        R = stoi(st.nextToken());

        graph = new Cell[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = new Cell(stoi(st.nextToken()), 0);
            }
        }

        while (true) {
            visited = new boolean[N][N];
            isOpen = false;
            unionNum = 0;
            List<Integer> unions = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        unions.add(bfs(i, j));
                        unionNum++;
                    }
                }
            }

            if (!isOpen) {
                break;
            }
            count++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = new Cell(unions.get(graph[i][j].union), 0);
                }
            }
        }

        System.out.println(count);
    }

    static int bfs(int ox, int oy) {
        Queue<Node> q = new LinkedList<>();
        visited[ox][oy] = true;
        q.add(new Node(ox, oy));
        graph[ox][oy].union = unionNum;

        int totalPeople = graph[ox][oy].people;
        int totalUnion = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowPeople = graph[now.x][now.y].people;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && (!visited[nx][ny])) {
                    int nPeople = graph[nx][ny].people;
                    int gap = Math.abs(nPeople - nowPeople);
                    if (L <= gap && gap <= R) {
                        visited[nx][ny] = true;
                        graph[nx][ny].union = unionNum;
                        totalPeople += nPeople;
                        totalUnion++;
                        isOpen = true;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }

        return totalPeople / totalUnion;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static class Cell {
        int people, union;

        public Cell(int people, int union) {
            this.people = people;
            this.union = union;
        }
    }
}
