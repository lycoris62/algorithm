import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        nums = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = stoi(st.nextToken());
        }

        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] < nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                } else if (nums[i] == nums[j]) {
                    dp[i] = dp[j];
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
