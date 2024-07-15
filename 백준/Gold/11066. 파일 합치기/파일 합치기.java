import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, K;
    static int[] sums;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            K = stoi(br.readLine());

            sums = new int[K + 1];
            dp = new int[K + 1][K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                sums[i] = sums[i - 1] + stoi(st.nextToken());
            }

            for (int endChapter = 2; endChapter <= K; endChapter++) {
                for (int startChapter = endChapter - 1; startChapter >= 1; startChapter--) {
                    dp[startChapter][endChapter] = Integer.MAX_VALUE;

                    for (int standard = startChapter; standard < endChapter; standard++) {
                        dp[startChapter][endChapter] = Math.min(dp[startChapter][endChapter], dp[startChapter][standard] + dp[standard + 1][endChapter]);
                    }

                    dp[startChapter][endChapter] += sums[endChapter] - sums[startChapter - 1];
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);
    }
}
