import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int rows = str2.length();
        int cols = str1.length();
        dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        int r = rows;
        int c = cols;
        while (r > 0 && c > 0) {
            if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else if (dp[r][c] == dp[r][c - 1]) {
                c--;
            } else {
                stack.push(str2.charAt(r - 1));
                r--;
                c--;
            }
        }

        System.out.println(dp[rows][cols]);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
