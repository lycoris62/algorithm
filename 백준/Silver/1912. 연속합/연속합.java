import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(max);
    }
}
