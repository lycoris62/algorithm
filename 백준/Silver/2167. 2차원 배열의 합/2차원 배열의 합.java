import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;
    static int[][] mat, sums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        mat = new int[N + 1][M + 1];
        sums = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                mat[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sums[i][j] = mat[i][j] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
            }
        }

        K = stoi(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = stoi(st.nextToken());
            int j = stoi(st.nextToken());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            int ans = sums[x][y] - sums[i - 1][y] - sums[x][j - 1] + sums[i - 1][j - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
