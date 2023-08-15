import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static int[][] res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        res = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                res[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    dfs(i, j, i, new boolean[N], 0);
                } else {
                    res[i][j] = 1;
                }
            }
        }

        for (int[] row : res) {
            for (int x : row) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int end, int now, boolean[] visited, int depth) {
        if (depth != 0 && end == now) {
            res[start][end] = 1;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == now || map[now][i] == 0 || visited[i]) continue;

            visited[i] = true;
            dfs(start, end, i, visited, depth + 1);
        }
    }
}
