import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        arr = new int[3][N + 1];
        dp = new int[3][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[j][i] = stoi(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + arr[2][i];
        }

        System.out.println(Math.min(Math.min(dp[0][N], dp[1][N]), dp[2][N]));
    }
}
