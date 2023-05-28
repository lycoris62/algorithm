import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] heights;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        heights = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            heights[i] = stoi(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            dp[i] = (i + heights[i] + 1 <= N) ? dp[i + heights[i] + 1] + 1 : 1;
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(dp[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}
