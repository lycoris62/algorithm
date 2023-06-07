import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        dp = new int[45];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 44; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + 1;
        }

        T = stoi(st.nextToken());
        while (T-- > 0) {
            N = stoi(br.readLine());
            
            for (int i = 1; i < 44; i++) {
                if (N < dp[i]) {
                    sb.append(i - 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
