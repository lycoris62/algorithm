import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, K;
    static final int LEN = 45;
    static int[] arr = new int[LEN];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        for (int i = 1; i < LEN; i++) {
            arr[i] = i * (i + 1) / 2;
        }

        while (T-- > 0) {
            K = stoi(br.readLine());

            sb.append(eureka(K)).append("\n");
        }

        System.out.println(sb);
    }

    static int eureka(int n) {
        for (int i = 1; i < LEN; i++) {
            for (int j = i; j < LEN; j++) {
                for (int k = j; k < LEN; k++) {
                    if (arr[i] + arr[j] + arr[k] == n) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}
