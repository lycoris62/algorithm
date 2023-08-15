import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int mid = 0; mid < N; mid++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if (map[start][mid] == 1 && map[mid][end] == 1) {
                        map[start][end] = 1;
                    }
                }
            }
        }

        for (int[] row : map) {
            for (int x : row) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
