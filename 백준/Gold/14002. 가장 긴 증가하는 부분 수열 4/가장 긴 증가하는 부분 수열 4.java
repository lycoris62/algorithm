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
        for (int i = 0; i < N; i++) {
            nums[i + 1] = stoi(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);

        Stack<Integer> stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            if (max == dp[i]) {
                stack.push(nums[i]);
                max--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
