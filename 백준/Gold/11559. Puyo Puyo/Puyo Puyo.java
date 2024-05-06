import java.io.*;
import java.util.*;

public class Main {

    static final int R = 12;
    static final int C = 6;
    static char[][] board = new char[R][C];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < R; i++) {
            String row = br.readLine();

            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // 1. 4개 이상 연결되어 있는지 확인
        // ㄴ 연쇄가 없다면 종료
        // 2. 다 터트리기 (.으로 만들기)
        // 3. 아래로 다 내려보내기.
        // 4. 1연쇄 추가

        sol();
    }

    static void sol() {

        int chainCount = 0;

        while (true) {
            visited = new boolean[R][C];
            boolean isChain = false;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!visited[i][j] && board[i][j] != '.') {
                        if (bfs(new Node(i, j, board[i][j]))) {
                            isChain = true;
                        }
                    }
                }
            }

            down();

            if (isChain) {
                chainCount++;
            } else {
                break;
            }
        }

        System.out.println(chainCount);
    }

    static void down() {
        for (int i = 0; i < C; i++) {
            for (int j = 10; j >= 0; j--) {
                for (int k = j; k < R - 1; k++) {
                    if (board[k][i] != '.' && board[k + 1][i] == '.') {
                        board[k + 1][i] = board[k][i];
                        board[k][i] = '.';
                    }
                }
            }
        }
    }

    static boolean bfs(Node start) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        List<Node> chain = new ArrayList<>();
        chain.add(start);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!isAccessible(nx, ny, now.color, visited)) {
                    continue;
                }

                visited[nx][ny] = true;
                Node next = new Node(nx, ny, now.color);
                q.add(next);
                chain.add(next);
            }
        }

        boolean isChain = chain.size() >= 4;

        if (isChain) {
            for (Node node : chain) {
                board[node.x][node.y] = '.';
            }
        }

        return isChain;
    }

    private static boolean isAccessible(int nx, int ny, char color, boolean[][] visited) {
        return (0 <= nx && nx < R) && (0 <= ny && ny < C) && (!visited[nx][ny]) && (board[nx][ny] == color);
    }

    static class Node {

        int x, y;
        char color;

        public Node(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
