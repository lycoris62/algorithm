import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] arr;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        for (int start = 1; start <= N; start++) {
            dp[start][start] = 1;
        }
        for (int start = 1; start < N; start++) {
            if (arr[start] == arr[start + 1])
                dp[start][start + 1] = 1;
        }
        for (int len = 2; len < N; len++) {
            for (int start = 1; start <= N - len; start++) {
                if (arr[start] == arr[start + len] && dp[start + 1][start + len - 1] == 1) {
                    dp[start][start + len] = 1;
                }
            }
        }

        M = stoi(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(dp[stoi(st.nextToken())][stoi(st.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }
}
