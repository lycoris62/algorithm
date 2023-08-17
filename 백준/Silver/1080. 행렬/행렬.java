import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt = 0;
    static int[][] mat, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mat = new int[N][M];
        res = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine().replaceAll(" ", "");
            for (int j = 0; j < M; j++) {
                mat[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine().replaceAll(" ", "");
            for (int j = 0; j < M; j++) {
                res[i][j] = str.charAt(j) - '0';
            }
        }

        sol();
        int ans = isCorrect() ? cnt : -1;
        System.out.println(ans);
    }

    static void sol() {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (mat[i][j] != res[i][j]) {
                    cnt++;
                    change(i, j);
                }
            }
        }
    }

    static void change(int n, int m) {
        for (int i = n; i < n + 3; i++) {
            for (int j = m; j < m + 3; j++) {
                mat[i][j] ^= 1;
            }
        }
    }

    static boolean isCorrect() {
        int flag = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == res[i][j]) {
                    flag++;
                }
            }
        }
        return flag == N * M;
    }
}
