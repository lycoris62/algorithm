import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static String[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Point> teachers = new ArrayList<>();
    static List<Point> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String x = sc.next();
                graph[i][j] = x;
                if (x.equals("T")) {
                    teachers.add(new Point(i, j));
                }
                if (x.equals("S")) {
                    students.add(new Point(i, j));
                }
            }
        }

        dfs(0);
        System.out.println("NO");
    }

    static void dfs(int depth) {
        if (depth == 3) {
            if (!catchStudent()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j].equals("X")) {
                    graph[i][j] = "O";
                    dfs(depth + 1);
                    graph[i][j] = "X";
                }
            }
        }
    }

    static boolean catchStudent() {
        boolean[][] check = new boolean[N][N];

        for (Point teacher : teachers) {
            int x = teacher.x;
            int y = teacher.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                while ((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
                    if (graph[nx][ny].equals("O")) break;

                    check[nx][ny] = true;
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        for (Point student : students) {
            if (check[student.x][student.y]) {
                return true;
            }
        }
        return false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
