import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static int[] dp, nums;
    static int N, M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N + 1];
        dp = new int[N + 1];

        IntStream.rangeClosed(1, N).forEach(i -> dp[i] = dp[i - 1] + (nums[i] = sc.nextInt()));

        while (M-- > 0) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt();
            System.out.println(dp[j] - dp[i]);
        }
    }
}
