import java.util.Scanner;

public class Main {

    static int T, N;
    static int[][] arr, dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();

            arr = new int[2][N + 1];
            dp = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int i = 2; i <= N; i++) {
                int noSelect = Math.max(dp[0][i - 2], dp[1][i - 2]);
                dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], noSelect);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], noSelect);
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
