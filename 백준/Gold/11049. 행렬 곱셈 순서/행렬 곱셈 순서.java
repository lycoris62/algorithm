import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Element[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        dp = new int[N][N];
        arr = new Element[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Element(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        for (int len = 1; len < N; len++) {
            for (int start = 0; start < N - len; start++) {
                int end = start + len;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    int cost = dp[start][mid] + dp[mid + 1][end] + arr[start].r * arr[mid].c * arr[end].c;
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }

    static class Element {
        int r, c;

        public Element(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
