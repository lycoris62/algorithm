import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int OP = 1_000_000_007;
    static int N;
    static int[] arr;
    static long scoville;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            scoville += arr[i] * pow(2, i);
            scoville -= arr[i] * pow(2, N - i - 1);
            scoville %= OP;
        }

        System.out.println(scoville);
    }

    static long pow(int base, int x) {
        if (x == 0) {
            return 1L;
        }

        long half = pow(base, x / 2);

        if (x % 2 == 0) {
            return half * half % OP;
        }
        return half * half * base % OP;
    }
}
