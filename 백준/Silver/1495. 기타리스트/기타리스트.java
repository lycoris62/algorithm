import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, M, answer = -1;
    static boolean[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N + 1];
        dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        st = new StringTokenizer(br.readLine()); 
        for (int i = 1; i <= N; i++) {
            arr[i] = stoi(st.nextToken());

            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    if (j + arr[i] <= M) {
                        dp[i][j + arr[i]] = true;
                    }
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] = true;
                    }
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}
