import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] RGB;
    static int[][] dp;
    static int cost = Integer.MAX_VALUE;
    static int max = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        RGB = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) RGB[i][j] = stoi(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[0][j] = RGB[0][i];
                else dp[0][j] = max;
            }

            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + RGB[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + RGB[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + RGB[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != i) cost = Math.min(cost, dp[N - 1][j]);
            }
        }

        System.out.println(cost);
    }
}
