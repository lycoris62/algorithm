import java.io.*;
import java.util.*;

public class Main {
    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int N;
    static long[] X, Y;
    static long sum1 = 0, sum2 = 0;
    static double res = 0.0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = new long[N + 1];
        Y = new long[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            X[i] = stol(st.nextToken());
            Y[i] = stol(st.nextToken());
        }

        X[N] = X[0];
        Y[N] = Y[0];

        for (int i = 0; i < N; i++) {
            sum1 += X[i] * Y[i + 1];
        }
        for (int i = 0; i < N; i++) {
            sum2 += X[i + 1] * Y[i];
        }

        res = Math.abs(sum1 - sum2) / 2.0;

        System.out.printf("%.1f", res);
    }
}
