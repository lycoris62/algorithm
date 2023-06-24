import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N, M;
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = stoi(st.nextToken());
        sol();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            System.out.println(dp[M][N]);
        }
    }

    static void sol() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    break;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }
}
