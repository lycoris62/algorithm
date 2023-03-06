import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            System.out.println(bi(N, K));
        }
    }

    static int bi(int n, int k) {
        int[][] tri = new int[n + 1][n + 1];
        tri[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) tri[i][j] = 1;
                else if (j == i) {
                    tri[i][j] = 1;
                    break;
                }
                else {
                    tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
                }
            }
        }
        return tri[n][k];
    }
}
