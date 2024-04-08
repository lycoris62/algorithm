import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger[] dp = new BigInteger[Math.max(2, N) + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = dp[2] = BigInteger.ONE;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[N]);
    }
}
