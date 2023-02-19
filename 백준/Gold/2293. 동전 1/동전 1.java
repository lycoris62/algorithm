import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int K;
    static List<Integer> list;
    static int[][] dp;
    static int[] dpp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        list = new ArrayList<>(N);
        dp = new int[N][K + 1];
        dpp = new int[K + 1];

//        int i = N;
//        while (i-- > 0) list.add(stoi(br.readLine()));
        for (int i = 0; i < N; i++) list.add(stoi(br.readLine()));

//        for (int i = 0; i <= K; i++) {
//            dp[0][i] = 1;
//        }
//        for (int j = 1; j < N; j++) {
//            for (int k = 0; k <= K; k++) {
//                if (k >= list.get(j))
//                    dp[j][k] = dp[j - 1][k] + dp[j][k - list.get(j)];
//                else
//                    dp[j][k] = dp[j - 1][k];
//            }
//        }
//        for (int[] ints : dp) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(dp[N - 1][K]);



        dpp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = list.get(i); j <= K; j++) {
                dpp[j] += dpp[j - list.get(i)];
            }
        }
//        for (int i : dpp) {
//            System.out.print(i + " ");
//        }
        System.out.println(dpp[K]);
    }
}
