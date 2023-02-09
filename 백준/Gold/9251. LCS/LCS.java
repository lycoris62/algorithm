import java.io.*;

public class Main {
    static Integer[][] dp;
    static char[] A;
    static char[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        dp = new Integer[A.length][B.length];
        System.out.println(LCS(A.length - 1, B.length - 1));
    }

    static int LCS(int x, int y) {

        if (x == -1 || y == -1) return 0;
        if (dp[x][y] == null) {
            dp[x][y] = 0;
            if (A[x] == B[y]) dp[x][y] = LCS(x - 1, y - 1) + 1;
            else dp[x][y] = Math.max(LCS(x, y - 1), LCS(x - 1, y));
        }
        return dp[x][y];
    }
}
