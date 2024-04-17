import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());

            arr = new int[N];
            long sum = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = stoi(st.nextToken());
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }
}
