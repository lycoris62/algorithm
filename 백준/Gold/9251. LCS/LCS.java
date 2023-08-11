import java.util.Scanner;

public class Main {

    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String first = sc.next();
        String second = sc.next();

        dp = new int[second.length() + 1][first.length() + 1];

        for (int i = 0; i < second.length(); i++) {
            for (int j = 0; j < first.length(); j++) {
                dp[i + 1][j + 1] = first.charAt(j) == second.charAt(i)
                        ? dp[i][j] + 1
                        : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        System.out.println(dp[second.length()][first.length()]);
    }
}
