import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[][] graph = new int[9][9];
    static List<Point> zeros = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int x = stoi(st.nextToken());
                graph[i][j] = x;
                if (x == 0) {
                    zeros.add(new Point(i, j));
                }
            }
        }

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == zeros.size()) {

            StringBuilder sb = new StringBuilder();

            for (int[] row : graph) {
                for (int x : row) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        Point now = zeros.get(depth);

        for (int i = 1; i <= 9; i++) {
            if (!isRight(now.x, now.y, i)) continue;
            graph[now.x][now.y] = i;
            dfs(depth + 1);
            graph[now.x][now.y] = 0;
        }
    }

    static boolean isRight(int x, int y, int n) {

        for (int i = 0; i < 9; i++) {
            if (i == y) continue;
            if (graph[x][i] == n) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == x) continue;
            if (graph[i][y] == n) return false;
        }

        int firstX = (x / 3) * 3;
        int firstY = (y / 3) * 3;

        for (int i = firstX; i < firstX + 3; i++) {
            for (int j = firstY; j < firstY + 3; j++) {
                if (i == x && j == y) continue;
                if (graph[i][j] == n) return false;
            }
        }

        return true;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
