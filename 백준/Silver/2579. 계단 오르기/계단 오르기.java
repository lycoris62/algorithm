import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dp, stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        dp = new int[N + 1];
        stairs = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            stairs[i] = stoi(br.readLine());
        }
        
        dp[1] = stairs[1];
        if (N > 1) {
            dp[2] = stairs[1] + stairs[2];
        }
        
        for (int i = 3; i <= N; i++) {
            dp[i] = stairs[i] + Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
