import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dp = new boolean[Math.max(3, N + 1)];

        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (dp[i]) {
                continue;
            }
            dp[i] = true;
            cnt++;
            if (cnt == K) {
                System.out.println(i);
                return;
            }
            for (int j = i * i; j <= N; j += i) {
                if (dp[j]) {
                    continue;
                }

                dp[j] = true;
                cnt++;
                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}